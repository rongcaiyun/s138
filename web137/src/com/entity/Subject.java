package com.entity;

public class Subject {
	private int subjectNo;
	private String subjectName;
	private int classHour;
	private int gradeId;
	public Subject(){}
	public Subject(int subjectNo, String subjectName, int classHour, int gradeId) {
		super();
		this.subjectNo = subjectNo;
		this.subjectName = subjectName;
		this.classHour = classHour;
		this.gradeId = gradeId;
	}
	public int getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getClassHour() {
		return classHour;
	}
	public void setClassHour(int classHour) {
		this.classHour = classHour;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	@Override
	public String toString() {
		return "Subject [subjectNo=" + subjectNo + ", subjectName="
				+ subjectName + ", classHour=" + classHour + ", gradeId="
				+ gradeId + "]";
	}
	
}
