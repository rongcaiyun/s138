package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Standard;
import com.service.StandardService;

@Controller
public class StandardController {
	@Autowired
	private StandardService standardService;

	@RequestMapping("/list.do")
	public String query(String std_num, Integer pageNo, Model model) {
		if (std_num == null)
			std_num = "";
		List<Standard> list = standardService.getListByCondition(std_num,
				pageNo);
		Integer pages = standardService.getPages(std_num);
		model.addAttribute("list", list);
		model.addAttribute("pages", pages);
		// model.addAttribute("pageNo",pageNo);
		// System.out.println(list.size());
		return "index";
	}

	// 跳转到addStandard.jsp
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String add() {
		return "addStandard";
	}
	@RequestMapping(value="/update.do", method = RequestMethod.GET)
	public String update(String stdNum,Model model){
		Standard sd=standardService.getStandardByStdNum(stdNum);
		
		model.addAttribute("sd", sd);
		return "addStandard";
	}
	@RequestMapping(value="/modify.do", method = RequestMethod.POST)
	public String modify(Standard sd,@RequestParam MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, IllegalStateException, IOException{
		if (file.isEmpty()) {
			System.out.println("文件未上传!");
		} else {
			// 得到上传的文件名
			String fileName = file.getOriginalFilename();
			// 得到服务器项目发布运行所在地址
			String path1 = request.getSession().getServletContext()
					.getRealPath("WEB-INF/views")
					+ File.separator;
			// 此处未使用UUID来生成唯一标识,用日期做为标识
			fileName = new SimpleDateFormat("yyyyMMddHHmmss")
					.format(new Date()) + fileName;
			String path = path1 + fileName;
			sd.setPackagePath("views\\" + fileName);
			// 打印文件上传路径，方便查看是否上传成功
			System.out.println(path);
			// 把文件上传至path的路径
			File localFile = new File(path);
			file.transferTo(localFile);
		}
		int count=standardService.updateStandard(sd);
		if (count == 0) {
			throw new SQLException("修改数据库失败");
		} else {
			return "redirect:list.do";
		}
	}
	//删除
	@RequestMapping(value="/del.do", method = RequestMethod.GET)
	public String del(String str){
		String[] array=str.split(",");
		for(int i=0;i<array.length;i++){
			standardService.del(Integer.parseInt(array[i]));
		}
		return "redirect:list.do";
	}
	// 将增加的数据保存到数据库
	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public String save(Standard st, @RequestParam MultipartFile file,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IllegalStateException, IOException {
		if (file.isEmpty()) {
			System.out.println("文件未上传!");
		} else {
			// 得到上传的文件名
			String fileName = file.getOriginalFilename();
			// 得到服务器项目发布运行所在地址
			String path1 = request.getSession().getServletContext()
					.getRealPath("WEB-INF/views")
					+ File.separator;
			// 此处未使用UUID来生成唯一标识,用日期做为标识
			fileName = new SimpleDateFormat("yyyyMMddHHmmss")
					.format(new Date()) + fileName;
			String path = path1 + fileName;
			st.setPackagePath("views\\" + fileName);
			// 打印文件上传路径，方便查看是否上传成功
			System.out.println(path);
			// 把文件上传至path的路径
			File localFile = new File(path);
			file.transferTo(localFile);
		}

		int count = standardService.saveStandard(st);
		if (count == 0) {
			throw new SQLException("增加数据库失败");
		} else {
			// return "redirect:list.do";
			PrintWriter pw;
			try {
				response.setContentType("text/html; charset=UTF-8");
				pw = response.getWriter();
				pw.write("<script>");
				pw.write("alert('增加成功!')");
				pw.write("location.href='list.do'");
				pw.write("</script>");
				return "redirect:list.do";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return "redirect:list.do";
	}
	
	@RequestMapping("/validateNum.do")
	public @ResponseBody Map<String, Object> validateStdNum(
			HttpServletRequest request, HttpServletResponse response) {
		Standard std = standardService.getStandardByStdNum(request
				.getParameter("stdNum"));
		Map<String, Object> map = new HashMap<String, Object>();
		if (std == null) {
			//System.out.println("成功");
			map.put("msg", "ok");
		} else {
			//System.out.println("失败");
			map.put("msg", "error");
		}
		return map;

	}

	@ExceptionHandler(value = { SQLException.class,
			IllegalStateException.class, IOException.class })
	public String handleException(Exception ex) {
		System.err.println(ex.getMessage());
		return "sqlError";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true)); // true:允许输入空值，false:不能为空值
	}
}
