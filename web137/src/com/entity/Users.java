package com.entity;

public class Users {
	private int id;
	private String uname;
	private String pwd;
	private String email;
	private String phone;
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String uname, String pwd, String email, String phone) {
		super();
		this.id = id;
		this.uname = uname;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
