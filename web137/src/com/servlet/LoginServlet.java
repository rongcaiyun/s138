package com.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.impl.UsersDaoImpl;
import com.entity.Users;

public class LoginServlet extends HttpServlet{
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet初始化");
		String str=config.getInitParameter("servletInit");
		System.out.println(str);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("service....");
		request.setCharacterEncoding("utf-8");
		//1.接收用户名、密码
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		//2.将用户名、密码传递后台数据层
		UsersDaoImpl ud=new UsersDaoImpl();
		Users u=ud.getUsersByName(uname, pwd);
		
		//3.判断返回的结果，如果成功则跳转到subjectQuery.jsp，否则跳转到login.jsp
		if(u!=null){
			//登录成功
			//将用户名保存到session中
			HttpSession session=request.getSession();
			session.setAttribute("user", uname);
			response.sendRedirect("subjectQuery.jsp");
		}
		else{
			//用户名或密码错误
			request.setAttribute("mess", "用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	@Override
	public void destroy() {
		System.out.println("servlet销毁");
	}
}
