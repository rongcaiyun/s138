package com.dao;

import java.util.List;

import com.entity.Subject;

public interface SubjectDao {
	public List<Subject> getAll();
	public Subject getSubjectByNo(int sjno);
	public int add(Subject subject);
	public int del(int subjectno);
	public int update(Subject subject);
}

