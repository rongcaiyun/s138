package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.UsersDaoImpl;
import com.entity.Users;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/regist.do")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取表单信息
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("uname");
		System.out.println(name);
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		Users u=new Users();
		u.setUname(name);
		u.setPhone(phone);
		u.setPwd(pwd);
		u.setEmail(email);
		//2.将表单信息传递给UsersDao
		UsersDaoImpl ud=new UsersDaoImpl();
		int count=ud.addUsers(u);
		if(count>0){
			//注册成功
			response.sendRedirect("login.jsp");
		}
		else{
			//注册失败
			response.sendRedirect("error.jsp");
		}
	}

}
