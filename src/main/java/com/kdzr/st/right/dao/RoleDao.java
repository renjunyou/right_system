package com.kdzr.st.right.dao;

import java.util.List;

import com.kdzr.st.right.dto.RolePrivilegeDto;
import com.kdzr.st.right.model.Role;

public interface RoleDao extends BaseDao<Role> {
	
	/*角色拥有哪些权限*/
	public List<RolePrivilegeDto> getPrivileges(String roleId);
	
	/*为某个角色授权 */
	public void addPrivilege2Role(RolePrivilegeDto rd);
	
	/*清除角色绑定的权限 */
	public void deleteRolePrivilege(String roleId);
	                              
}
