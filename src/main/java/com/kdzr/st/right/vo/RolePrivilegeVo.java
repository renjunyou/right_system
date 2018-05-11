package com.kdzr.st.right.vo;

import java.util.List;

public class RolePrivilegeVo {
	
	private String roleId;
	
	private List<String> privilegeList;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<String> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<String> privilegeList) {
		this.privilegeList = privilegeList;
	}
	
	

}
