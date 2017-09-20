package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AuctionRecordMapper;
import com.entity.Auction;
import com.entity.AuctionRecord;
import com.service.AuctionRecordService;
import com.service.AuctionService;
import com.util.PageUtil;

@Service
public class AuctionRecordServiceImpl implements AuctionRecordService {
	@Autowired
	private AuctionRecordMapper auctionRecordMapper;
	@Override
	public List<AuctionRecord> getRecordById(Integer id) {
		// TODO Auto-generated method stub
		return auctionRecordMapper.getAuctionRecordById(id);
	}
	@Override
	public int saveRecord(AuctionRecord ar) {
		//查询商品的最高出价
		AuctionRecord arecord=auctionRecordMapper.getMaxPrice(ar.getAuction().getAuctionId());
		if(arecord!=null){
			//没有出价记录
			if(arecord.getAuctionPrice()>=ar.getAuctionPrice()){
				//出价低于最高价
				return -1;
			}
		}
		
		try {
			auctionRecordMapper.save(ar);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	@Override
	public List<AuctionRecord> getAuctionEndResult() {
		return auctionRecordMapper.getAuctionEndResult();
	}


}
