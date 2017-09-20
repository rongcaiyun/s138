package com.dao;

import java.util.List;

import com.entity.AuctionRecord;

public interface AuctionRecordMapper {
	public List<AuctionRecord> getAuctionRecordById(Integer id);

	public void save(AuctionRecord ar);
	//根据ID查找最高出价记录
	public AuctionRecord getMaxPrice(Integer id);
	public List<AuctionRecord> getAuctionEndResult();
	
}
