package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.Standard;

@Repository
public interface StandardMapper {
	public List<Standard> getListByCondition(Map map);
	public Integer getCounts(String stdNum);
	public int save(Standard standard);
	public Standard getStandardByStdNum(String stdNum);
	public int updateStandard(Standard sd);
	public int del(int parseInt);
}
