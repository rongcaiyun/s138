<%@page import="com.dao.impl.SubjectDaoImpl"%>
<%@page import="com.entity.Subject"%>
<%@page import="com.dao.SubjectDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//获取课程编号
	String sno=request.getParameter("sno");
	if(sno!=null){
		int subjectno=Integer.parseInt(sno);
		SubjectDao sd=new SubjectDaoImpl();
		Subject subject=sd.getSubjectByNo(subjectno);
		//跳转到test.jsp
		request.setAttribute("subject", subject);
		request.getRequestDispatcher("test.jsp").forward(request, response);
	}
	
%>