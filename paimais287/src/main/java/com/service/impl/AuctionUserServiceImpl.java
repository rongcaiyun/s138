package com.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AuctionUserMapper;
import com.entity.AuctionUser;
import com.service.AuctionUserService;

@Service
public class AuctionUserServiceImpl implements AuctionUserService {
	@Autowired
	private AuctionUserMapper AuctionUserMapper;
	@Override
	public Map<String, Object> login(String uname, String password) {
		//
		Map<String,Object> map=new HashMap<String, Object>();
		AuctionUser user=AuctionUserMapper.getUserByName(uname);
		if(user==null){
			//帐户不存在
			map.put("status", "-1");
		}
		else{
			//帐户存在
			if(user.getUserPassword().equals(password)){
				//登录成功
				map.put("status", "1");
				map.put("user", user);
			}
			else{
				//密码错误
				map.put("status", "0");
			}
		}
		return map;
	}

}
