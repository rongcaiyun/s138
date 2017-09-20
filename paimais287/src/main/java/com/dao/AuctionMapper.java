package com.dao;

import java.util.List;

import com.entity.Auction;

public interface AuctionMapper {
	public List<Auction> getAuctionList(Auction auction);

	public Auction getAuctionById(Integer id);

	public int getMaxAuctionId();

	public void addAuction(Auction auction);
	public List<Auction> getNotEndResult();
	
}
