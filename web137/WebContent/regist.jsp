<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>用户注册</h2>
	<form action="regist.do" method="post">
		用户名：<input type="text" name="uname"/><br/>
		密码：<input type="password" name="pwd"/><br/>
		确认密码：<input type="password" name="repwd"/><br/>
		
		email：<input type="text" name="email"/><br/>
		电话：<input type="text" name="phone"/><br/>
		<input type="submit" value="注册"/>
	</form>
</body>
</html>