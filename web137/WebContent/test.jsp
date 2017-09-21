<%@page import="com.entity.Subject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>根据课程编号查询</h2>
	<form action="subjectdo.jsp" method="post">
		编号：<input type="text" name="sno"/><br/>
		<input type="submit"/>
	</form>
	<h3>当前科目信息</h3>
	<%
		Object obj1=request.getAttribute("subject");
		if(obj1!=null){
			Subject obj=(Subject)obj1;
	
	%>
	编号：<%=obj.getSubjectNo() %>
	名称：<%=obj.getSubjectName() %>
	课时：<%=obj.getClassHour() %>
	年级编号：<%=obj.getGradeId() %>
	<%} %>
</body>
</html>