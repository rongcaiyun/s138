package com.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AuctionMapper;
import com.entity.Auction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.AuctionService;
import com.util.PageUtil;

@Service
public class AuctionServiceImpl implements AuctionService {
	private int size=5;//每页最大记录数
	@Autowired
	private AuctionMapper auctionMapper;
	@Override
	public PageUtil getAuctionList(Auction auction, int pageNo) {
		// TODO Auto-generated method stub
		//分页处理，显示第pageNo页的size条数据
        PageHelper.startPage(pageNo, size);
        List<Auction> list=auctionMapper.getAuctionList(auction);
        System.out.println(list.get(0).getAuctionStartTime());
        // 取分页信息
        PageInfo<Auction> pageInfo = new PageInfo<Auction>(list);
        //long total = pageInfo.getTotal(); //获取总记录数
        long total=pageInfo.getPages();//获取总页数
        PageUtil pu=new PageUtil();
        pu.setList(list);
        pu.setCount(total);
        return pu;
	}
	@Override
	public Auction getAuctionById(Integer id) {
		Auction au=auctionMapper.getAuctionById(id);
		return au;
	}
	@Override
	public void addAuction(Auction auction) throws RuntimeException{
		int maxAuctionId=auctionMapper.getMaxAuctionId();
		auction.setAuctionId(maxAuctionId+1);
		auctionMapper.addAuction(auction);

	}
	@Override
	public List<Auction> getNotEndResult() {
		// TODO Auto-generated method stub
		return auctionMapper.getNotEndResult();
	}

}
