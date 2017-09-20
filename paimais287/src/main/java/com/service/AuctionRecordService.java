package com.service;

import java.util.List;

import com.entity.AuctionRecord;

public interface AuctionRecordService {
	public List<AuctionRecord> getRecordById(Integer id);

	public int saveRecord(AuctionRecord ar);
	public List<AuctionRecord> getAuctionEndResult();
}
