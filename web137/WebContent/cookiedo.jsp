<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] ck=request.getCookies();
	if(ck!=null){
		for(int i=0;i<ck.length;i++){
			out.print("cookieName:"+ck[i].getName()+",cookieValue:"+ck[i].getValue()+",有效期："+ck[i].getMaxAge());
		}
	}
	else{
		out.print("没有cookie信息");
	}
	//服务器端向cookie中存入信息
	Cookie cookie=new Cookie("cookieName"+(int)(Math.random()*10),"cookieValue"+(int)(Math.random()*10));
	response.addCookie(cookie);
%>