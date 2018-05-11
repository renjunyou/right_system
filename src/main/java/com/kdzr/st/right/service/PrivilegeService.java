package com.kdzr.st.right.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdzr.st.right.dao.PrivilegeDao;
import com.kdzr.st.right.model.Privilege;

@Service
public class PrivilegeService {
	
	@Autowired
	private PrivilegeDao privilegeDao;
	
	// 添加权限
	public void addPrivilege(Privilege p) {
		privilegeDao.save(p);
	}
	
	//修改权限
	public void updatePrivilege(Privilege p) {
		privilegeDao.update(p);
	}
	
	//删除权限
	public void deletePrivilege(String privilegeId) {
		privilegeDao.delete(privilegeId);
	}
	
	// 根据id查找权限
	public Privilege findPrivilege(String id) {
		return privilegeDao.queryObject(id);
	}

	//得到所有的权限
	public List<Privilege> getAllPrivilege() {
		return privilegeDao.queryList(null);
	}



}
