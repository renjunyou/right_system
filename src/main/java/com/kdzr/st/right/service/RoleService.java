package com.kdzr.st.right.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdzr.st.right.dao.RoleDao;
import com.kdzr.st.right.dto.RolePrivilegeDto;
import com.kdzr.st.right.model.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	// 添加角色
	public void addRole(Role role) {
		roleDao.save(role);
	}
	
	//修改角色
	public void updateRole(Role role) {
		
		roleDao.update(role);
		
	}
	
	//删除角色
	public void deleteRole(String roleId) {
		
		roleDao.delete(roleId);
		
	}
	
	// 根据id查找角色
	public Role findRole(String id) {
		return roleDao.queryObject(id);
	}

	//得到所有的角色
	public List<Role> getAllRoles() {
		return roleDao.queryList(null);
	}

	//获取角色所有的权限
	public List<RolePrivilegeDto> getRolePrivilege(String roleId) {
		return roleDao.getPrivileges(roleId);
	}
	
	//修改角色的权限
	public void updateRolePrivilege(String roleId,List<RolePrivilegeDto> rpdList) {
		
		//先删除角色
		roleDao.deleteRolePrivilege(roleId);
		
		//在重新添加
		if(rpdList.size() > 0) {//前台没有勾选任何权限   则只清空所有权限，没有添加步骤
			for (RolePrivilegeDto rpd : rpdList) {
				roleDao.addPrivilege2Role(rpd);
			}
		}
		
	}
	


}
