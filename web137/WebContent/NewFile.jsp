<%@page import="com.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("users", "request");
		Users us=new Users(1,"abc","111","111","1111");
		request.setAttribute("us", us);
	%>
	${users }<br/>
	users:${requestScope.us.uname},${us.id },${us.pwd }
</body>
</html>