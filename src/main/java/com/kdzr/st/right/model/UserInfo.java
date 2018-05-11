package com.kdzr.st.right.model;

public class UserInfo {
	
	private User user;
	private String status;//登录状态  0：成功；1：用户名不存在；2：密码错误；
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
