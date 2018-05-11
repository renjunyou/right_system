package com.kdzr.st.right.controllor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdzr.st.right.dto.UserRoleDto;
import com.kdzr.st.right.model.Role;
import com.kdzr.st.right.model.User;
import com.kdzr.st.right.service.RoleService;
import com.kdzr.st.right.service.UserService;
import com.kdzr.st.right.vo.UserRoleVo;
import com.kdzr.utils.UUIDTool;

@Controller
@RequestMapping("user")
public class UserControllor {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/list")
	public String getAllUser(Model model) {
		
		model.addAttribute("userlist", userService.getAllUser());
		
		return "user/user_list";
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addUser() {
		
		return "user/add_user";
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addUser(User user) {
		user.setId(UUIDTool.getUUID());
		userService.addUser(user);
		
		return "redirect:list";
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateUser(String userId,Model model) {
		model.addAttribute("user",userService.findUser(userId));
		
		return "user/update_user";
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateUser(User user) {
		userService.updateUser(user);
		
		return "redirect:list";
		
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteUser(String userId) {
		userService.deleteUser(userId);
		
		return "redirect:list";
		
	}
	
	@RequestMapping(value="/addUserRole",method=RequestMethod.GET)
	public String addUserRole(String userId,Model model) {
		//获取该用户所有的角色 
		List<UserRoleDto> userRoles = userService.getUserRole(userId); 
		//得到全部的角色 
		List<Role> allRoles = roleService.getAllRoles(); 
		//为用户授权的JSP页面也应该显示用户的信息，所以把User对象也传递过去给JSP页面 
		User user = userService.findUser(userId); 
		model.addAttribute("user", user); 
		model.addAttribute("userRoles", userRoles); 
		model.addAttribute("allRoles", allRoles);
		
		return "user/lookUserRole";
		
		
	}
	
	//保存用户绑定角色数据
	@RequestMapping(value="/addUserRole",method=RequestMethod.POST)
	public String addUserRole(UserRoleVo urv,Model model) {
		String userId = urv.getUserId();
		List<UserRoleDto> urdList = new ArrayList<UserRoleDto>();
		if(urv.getRoleIdList() != null) {
			for(int i=0;i<urv.getRoleIdList().size();i++) {
				UserRoleDto urd = new UserRoleDto();
				urd.setUserid(urv.getUserId());
				urd.setRoleid(urv.getRoleIdList().get(i));
				urdList.add(urd);
			}
		}
		
		//更新用户角色（先删除，后添加）
		userService.updateUserRole(userId,urdList);
		
		return "redirect:list";
		
	}
	
	//根据用户名查询用户
	@RequestMapping(value="/checkUserName",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String checkUserName(String username) {
		
		User user = userService.queryUserByName(username);
		Map<String,Object> map = new HashMap<String,Object>();
		//这种方式利用ObjectMapper中的writeValueAsString将Java对象转换为json字符串。
        ObjectMapper mapper = new ObjectMapper();
		
		if(user == null) {
			map.put("msg", "true");
		}else {
			map.put("msg", "false");
		}
		
		String result = "";
		try {
			result = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	

}
