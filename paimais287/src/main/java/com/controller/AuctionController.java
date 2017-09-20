package com.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Auction;
import com.entity.AuctionRecord;
import com.entity.AuctionUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.AuctionRecordService;
import com.service.AuctionService;
import com.util.PageUtil;

/**
 * 显示拍卖品列表类
 * @author doubles
 *
 */
@Controller
public class AuctionController {
	@Autowired
	private AuctionService auctionService;
	@Autowired
	private AuctionRecordService auctionRecordService;
	@RequestMapping("/auctionList.do")
	public ModelAndView list(Auction auction,@RequestParam(defaultValue="1")Integer pageNo){
		if(auction==null) auction=new Auction();
		PageUtil pu=auctionService.getAuctionList(auction, pageNo);
		ModelAndView mv=new ModelAndView();
		mv.addObject("pageNo", pageNo);
		mv.addObject("pu", pu);
		mv.setViewName("auctionList");
		return mv;
	}
	
	
	@RequestMapping("/auction.do")
	public String getAuctionById(Integer id,Model model){
		Auction auction=auctionService.getAuctionById(id);
		model.addAttribute("auction", auction);
		model.addAttribute("record",auctionRecordService.getRecordById(id));
		return "auction";
	}
	//查询拍卖记录的最高价
	//ajax
	@RequestMapping("/saveAuctionRecord.do")
	public String saveAuctionRecord(Integer id,Double price,HttpSession session,Model model){
		
		AuctionRecord ar=new AuctionRecord();
		ar.setAuctionTime(new Date());
		ar.setAuctionPrice(price);
		Auction auction=new Auction();
		auction.setAuctionId(id);
		ar.setAuction(auction);
		AuctionUser auctionUser=(AuctionUser) session.getAttribute("user");
		ar.setAuctionUser(auctionUser);
		synchronized ("abc") {
			
		
			int count=auctionRecordService.saveRecord(ar);
			if(count==1){
				//成功
				//Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
				model.addAttribute("mess","<font color='green' fontsize='14px'>出价成功</font>");
				
			}
			else if(count==0){
				model.addAttribute("mess","出价失败");
			}
			else{
				model.addAttribute("mess","不能低于最高竞拍价");
			}
		}
		return "forward:auction.do";
	}
	
	@RequestMapping(value="/addAuction.do",method=RequestMethod.POST)
	public String addAuction(Auction auction,@RequestParam MultipartFile myfiles, HttpServletRequest request){
		if(myfiles.isEmpty()){
            System.out.println("文件未上传!");
        }
        else{
            //得到上传的文件名
            String fileName = myfiles.getOriginalFilename();
            fileName=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+ fileName;
            auction.setAuctionPic(fileName);
            String type=myfiles.getContentType();
            auction.setAuctionPicType(type);
            //得到服务器项目发布运行所在地址
            String path1 = request.getSession().getServletContext().getRealPath("/images")+ File.separator;
            //  此处未使用UUID来生成唯一标识,用日期做为标识
            String path = path1+ fileName;
            //打印文件上传路径，方便查看是否上传成功
            System.out.println(path);
            //把文件上传至path的路径
            File localFile = new File(path);
            try {
				myfiles.transferTo(localFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		auctionService.addAuction(auction);
		//查询最大编号+1==id
		System.out.println(auction);
		return "redirect:auctionList.do";
	}
	@RequestMapping(value="/addAuction.do",method=RequestMethod.GET)
	public String addAuction(){
		return "add";
	}
	
}
