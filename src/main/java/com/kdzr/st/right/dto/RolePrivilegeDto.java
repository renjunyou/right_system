package com.kdzr.st.right.dto;

public class RolePrivilegeDto {
	
	private String roleid;
	private String rolename;
	private String privilegeid;
	private String privilegename;
	private String privilegedesc;
	
	public String getPrivilegeid() {
		return privilegeid;
	}
	public void setPrivilegeid(String privilegeid) {
		this.privilegeid = privilegeid;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getPrivilegename() {
		return privilegename;
	}
	public void setPrivilegename(String privilegename) {
		this.privilegename = privilegename;
	}
	public String getPrivilegedesc() {
		return privilegedesc;
	}
	public void setPrivilegedesc(String privilegedesc) {
		this.privilegedesc = privilegedesc;
	}

}
