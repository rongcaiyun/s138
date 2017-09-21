package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.util.ConfigManger;

public class BaseDao {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	public void getConn() throws ClassNotFoundException, SQLException {
		/*String driver=ConfigManger.getInstance().getString("jdbc.driver");
		String url=ConfigManger.getInstance().getString("jdbc.url");
		String username=ConfigManger.getInstance().getString("jdbc.username");
		String pwd=ConfigManger.getInstance().getString("jdbc.password");*/
		
		// 1.注册驱动
		//Class.forName(driver);
		// 2.获取连接对象
		//conn = DriverManager.getConnection(
		//		url, username, pwd);
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myschool");
			conn = ds.getConnection();
			System.out.println("连接成功");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
	}
	/**
	 * 执行增、删、改
	 */
	public int executeSql(String sql, Object... objs) {
		// 2.获取连接
		try {
			getConn();
			// 3.执行SQL
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstm.setObject((i + 1), objs[i]);
			}
			int count = pstm.executeUpdate();
			return count;
			// 4.关闭
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return 0;
	}
	public void closeAll() {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(pstm!=null)
			pstm.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
