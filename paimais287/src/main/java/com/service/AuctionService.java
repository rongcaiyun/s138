package com.service;

import java.util.List;

import com.entity.Auction;
import com.util.PageUtil;

public interface AuctionService {
	public PageUtil getAuctionList(Auction auction,int pageNo);

	public Auction getAuctionById(Integer id);

	public void addAuction(Auction auction);
	public List<Auction> getNotEndResult();
}
