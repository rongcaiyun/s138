package com.dao.impl;

import java.sql.SQLException;

import com.entity.Users;

public class UsersDaoImpl extends BaseDao{
	/**
	 * 通过用户名密码判断用户是否存在，实现了登录的功能
	 * @param uname
	 * @param pwd
	 * @return
	 */
	public Users getUsersByName(String uname,String pwd){
		//1.获取连接
		try {
			super.getConn();
			//2.执行SQL语句
			String sql="select * from users where uname=? and pwd=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, uname);
			pstm.setString(2, pwd);
			rs=pstm.executeQuery();
			if(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String password=rs.getString("pwd");
				Users users=new Users();
				users.setId(id);
				users.setUname(name);
				users.setPwd(password);
				return users;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			super.closeAll();
		}
		return null;
	}
	public int addUsers(Users users){
		String sql="insert into users(uname,pwd,email,phone) values(?,?,?,?)";
		return super.executeSql(sql, users.getUname(),users.getPwd(),users.getEmail(),users.getPhone());
	}
}
