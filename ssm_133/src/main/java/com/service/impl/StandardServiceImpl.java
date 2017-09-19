package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StandardMapper;
import com.entity.Standard;
import com.service.StandardService;

@Service
public class StandardServiceImpl implements StandardService {
	private int pageSize=4;
	@Autowired
	private StandardMapper standardMapper;
	public List<Standard> getListByCondition(String str,Integer pageNo) {
		// 通过pageNo，转换成beginIndex
		if(pageNo==null)
			pageNo=1;
		int beginIndex=(pageNo-1)*pageSize;
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("stdNum", str);
		map.put("beginIndex", beginIndex);
		map.put("pageSize", pageSize);
		return standardMapper.getListByCondition(map);
	}
	public Integer getPages(String stdNum) {
		// TODO Auto-generated method stub
		Integer counts=standardMapper.getCounts(stdNum);
		//将记录数转换为总页数
		int pages=counts%pageSize==0?counts/pageSize:counts/pageSize+1;
		return pages;
	}
	//保存standard对象
	public int saveStandard(Standard standard) {
		// TODO Auto-generated method stub
		return standardMapper.save(standard);
	}
	public Standard getStandardByStdNum(String stdNum) {
		// TODO Auto-generated method stub
		Standard sd=standardMapper.getStandardByStdNum(stdNum);
		return sd;
	}
	public int updateStandard(Standard sd) {
		return standardMapper.updateStandard(sd);
	}
	public int del(int id) {
		// TODO Auto-generated method stub
		return standardMapper.del(id);
	}

}
