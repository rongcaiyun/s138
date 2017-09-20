package com.service;

import java.util.Map;

import com.entity.AuctionUser;

public interface AuctionUserService {
	public Map<String,Object> login(String uname,String password);
}
