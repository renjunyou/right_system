package com.kdzr.st.right.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdzr.st.right.dao.UserDao;
import com.kdzr.st.right.dto.UserRoleDto;
import com.kdzr.st.right.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	// 添加用户
	public void addUser(User user) {
		userDao.save(user);
	} 
	
	//修改用户
	public void updateUser(User user) {
		
		userDao.update(user);
		
	}
	
	//修改用户
	public void deleteUser(String userId) {
		
		userDao.delete(userId);
		
	}
	
	// 根据id查找用户
	public User findUser(String id) {
		return userDao.queryObject(id);
	}

	//得到所有的用户
	public List<User> getAllUser() {
		return userDao.queryList(null);
	}

	//获取用户所有的角色
	public List<UserRoleDto> getUserRole(String user_id) {
		return userDao.getRoles(user_id);
	}
	
	//修改用户的角色
	public void updateUserRole(String userId,List<UserRoleDto> urdList) {
		//先删除角色
		userDao.deleteUserRole(userId);
		//在重新添加
		if(urdList.size() > 0) {//前台没有勾选任何角色   则只清空所有权限，没有添加步骤
			for (UserRoleDto urd : urdList) {
				userDao.updateRole(urd);
			}
		}
	}
	
	//根据用户名查询用户
	public User queryUserByName(String username) {
		
		return userDao.queryUserByName(username);
	}
	
	

}
