package com.service.impl;

import java.util.List;

import com.dao.SubjectDao;
import com.dao.impl.SubjectDaoImpl;
import com.entity.Subject;
import com.service.SubjectService;

/**
 * 业务逻辑
 * @author Administrator
 *
 */
public class SubjectServiceImpl implements  SubjectService{
	SubjectDao sd=new SubjectDaoImpl();
	public List<Subject> querySubject(){
		return sd.getAll();
	}
	
}
