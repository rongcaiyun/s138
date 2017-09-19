package com.service;

import java.util.List;

import com.entity.Standard;

public interface StandardService {
	public List<Standard> getListByCondition(String str,Integer pageNo);
	//统计有多少页
	public Integer getPages(String stdNum);
	//保存
	public int saveStandard(Standard standard);
	public Standard getStandardByStdNum(String stdNum);
	public int updateStandard(Standard sd);
	public int del(int id);
}
