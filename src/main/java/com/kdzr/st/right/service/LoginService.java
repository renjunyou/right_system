package com.kdzr.st.right.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdzr.st.right.dao.UserDao;
import com.kdzr.st.right.model.User;
import com.kdzr.st.right.model.UserInfo;

@Service
public class LoginService {
	
	@Autowired
	private UserDao userDao;
	
	public UserInfo checkUser(User user) {
		//User 用户表，用户名业务唯一
		User user_db = userDao.queryUserByName(user.getUsername());
		UserInfo ui = new UserInfo();
		//山木运算  如果找到了user 并且 自己输入的password 
		//跟数据库查出来的user.getUserPass() 一致 则返回true 否则返回false
		if(user_db == null) {
			ui.setStatus("1");//用户名不正确
			return ui;
		}else if (user.getPassword().equals(user_db.getPassword())) {
			ui.setStatus("0");//登录成功
			ui.setUser(user_db);
			return ui;
		}
		ui.setStatus("2");
		return ui;//密码错误
		
	}

}
