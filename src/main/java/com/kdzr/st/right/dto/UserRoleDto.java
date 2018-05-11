package com.kdzr.st.right.dto;

public class UserRoleDto {
	
	private String userid;
	private String username;
	private String roleid;
	private String rolename;
	private String descp;
	
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	@Override
	public String toString() {
		return "UserRoleDto [userid=" + userid + ", username=" + username + ", roleid=" + roleid + ", rolename="
				+ rolename + ", descp=" + descp + "]";
	}
	
	
	

}
