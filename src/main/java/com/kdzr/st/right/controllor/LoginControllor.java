package com.kdzr.st.right.controllor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kdzr.st.right.model.User;
import com.kdzr.st.right.model.UserInfo;
import com.kdzr.st.right.service.LoginService;
import com.kdzr.st.right.service.UserService;
import com.kdzr.utils.UUIDTool;

@Controller
@RequestMapping("login")
public class LoginControllor {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,Model model,HttpServletRequest req) {
		UserInfo ui = loginService.checkUser(user);
		
		if(ui.getStatus() == "2") {
			model.addAttribute("loginMessage", "密码错误");
			return "login";
		}else if(ui.getStatus() == "1") {
			model.addAttribute("loginMessage", "用户名不存在");
			return "login";
		}
		//model.addAttribute("loginMessage", "登录成功");
		//登入，设置session
		req.getSession().setAttribute("userinfo", ui);
		
		return "index";
	}
	
	//登出
	@RequestMapping(value="/loginout",method=RequestMethod.GET)
	public String loginout(HttpServletRequest req) {
		
		//注销，删除session
		req.getSession().removeAttribute("userinfo");
		req.getSession().invalidate();
		
		return "login";
	}
	
	//跳转注册页面
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register() {
		
		return "register";
	}
	
	//注册提交
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(User user,Model model) {
		
		User user_db = userService.queryUserByName(user.getUsername());
		if(user_db == null) {
			user.setId(UUIDTool.getUUID());
			userService.addUser(user);
			return "register_succ";
			
		}
		model.addAttribute("reg_meg", "用户名已经存在");
		
		return "register";
	}
	

}
