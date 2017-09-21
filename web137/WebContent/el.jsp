<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		用户名：<input type="text" name="uname" value="${param.uname}"/><br/>
		密码：<input type="password" name="pwd" value="${param.pwd}"/><br/>
		性别：<input type="radio" name="sex" value="male"/>男
			<input type="radio" name="sex" value="female"/>女<br/>
		爱好：<input type="checkbox" name="hobby" value="basketball"/>打篮球
		<input type="checkbox" name="hobby" value="majiang"/>打麻将
		<input type="checkbox" name="hobby" value="travelling"/>旅游
		城市：<select name="city">
			<option value="beijing">北京</option>
			<option value="shanghai">上海</option>
			<option value="tianjin">天津</option>
		</select><br/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>