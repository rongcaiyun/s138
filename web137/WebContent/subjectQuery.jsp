<%@page import="com.service.impl.SubjectServiceImpl"%>
<%@page import="com.service.SubjectService"%>
<%@page import="com.entity.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	你好:${user}
	<h2>科目信息列表</h2>
	<table border="1">
		<tr>
			<td>科目编号</td>
			<td>科目名称</td>
			<td>课时数</td>
			<td>年级编号</td>
		</tr>
		<%
			SubjectService sd = new SubjectServiceImpl();
			List<Subject> list=sd.querySubject();
			request.setAttribute("list", list);
			/* for(Subject subject:list){ */
		%>
		<c:forEach var="subject" items="${list}" varStatus="stuts">
		<c:if test="${stuts.index%2==1}">
			<tr bgcolor="red">
		</c:if>
		<c:if test="${stuts.index%2==0}">
		<tr bgcolor="yellow">
		</c:if>
			<td>${subject.subjectNo}</td>
			<td>${subject.subjectName}</td>
			<td>${subject.classHour}</td>
			<td>${subject.gradeId}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>