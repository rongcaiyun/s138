<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	用户名：${param.uname}<br/>
	密码：${param.pwd}<br/>
	性别：${param.sex}<br/>
	爱好：${paramValues.hobby[0]}${paramValues.hobby[1]}${paramValues.hobby[2]}<br/>
	城市：${param.city}<br/>
</body>
</html>