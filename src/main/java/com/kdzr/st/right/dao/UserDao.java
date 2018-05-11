package com.kdzr.st.right.dao;

import java.util.List;

import com.kdzr.st.right.dto.UserRoleDto;
import com.kdzr.st.right.model.User;

public interface UserDao extends BaseDao<User> {
	
	/*获取用户的所有角色*/
	public List<UserRoleDto> getRoles(String userId);
	
	/*更新用户角色*/
	public void updateRole(UserRoleDto urd);
	
	/*清空用户角色*/
	public void deleteUserRole(String userId);
	
	/*根据用户名查询用户信息*/
	public User queryUserByName(String username);
	
	
}
