package com.dao;

import org.springframework.stereotype.Repository;

import com.entity.AuctionUser;

@Repository
public interface AuctionUserMapper {
	public AuctionUser getUserByName(String uname);
}
