package com.kdzr.st.right.controllor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kdzr.st.right.dto.RolePrivilegeDto;
import com.kdzr.st.right.model.Privilege;
import com.kdzr.st.right.model.Role;
import com.kdzr.st.right.service.PrivilegeService;
import com.kdzr.st.right.service.RoleService;
import com.kdzr.st.right.vo.RolePrivilegeVo;
import com.kdzr.utils.UUIDTool;

@Controller
@RequestMapping("privilege")
public class PrivilegeControllor {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private PrivilegeService privilegeService;
	
	@RequestMapping("/list")
	public String getAllPrivilege(Model model) {
		
		model.addAttribute("privilegelist", privilegeService.getAllPrivilege());
		
		return "privilege/privilege_list";
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addRole() {
		
		return "privilege/add_privilege";
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addPrivilege(Privilege privilege) {
		privilege.setId(UUIDTool.getUUID());
		privilegeService.addPrivilege(privilege);
		
		return "redirect:list";
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updatePrivilege(String privilegeId,Model model) {
		model.addAttribute("privilege",privilegeService.findPrivilege(privilegeId));
		
		return "privilege/update_privilege";
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updatePrivilege(Privilege privilege) {
		privilegeService.updatePrivilege(privilege);
		
		return "redirect:list";
		
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deletePrivilege(String privilegeId) {
		privilegeService.deletePrivilege(privilegeId);
		
		return "redirect:list";
		
	}
	
	
	@RequestMapping(value="/addRolePrivilege",method=RequestMethod.GET)
	public String addUserRole(String roleId,Model model) {
		//获取该角色所有的权限
		List<RolePrivilegeDto> rolePrivilege = roleService.getRolePrivilege(roleId); 
		//得到全部的权限
		List<Privilege> allPrivilege = privilegeService.getAllPrivilege();
		//为用户授权的JSP页面也应该显示用户的信息，所以把User对象也传递过去给JSP页面 
		Role role = roleService.findRole(roleId); 
		model.addAttribute("role", role); 
		model.addAttribute("rolePrivilege", rolePrivilege); 
		model.addAttribute("allPrivilege", allPrivilege);
		
		return "role/lookRolePrivilege";
		
		
	}
	
	//保存角色绑定权限数据
	@RequestMapping(value="/addRolePrivilege",method=RequestMethod.POST)
	public String addUserRole(RolePrivilegeVo rpv,Model model) {
		String roleId = rpv.getRoleId();
		List<RolePrivilegeDto> rpdList = new ArrayList<RolePrivilegeDto>();
		if(rpv.getPrivilegeList() != null) {
			for(int i=0;i<rpv.getPrivilegeList().size();i++) {
				RolePrivilegeDto rpd = new RolePrivilegeDto();
				rpd.setRoleid(rpv.getRoleId());
				rpd.setPrivilegeid(rpv.getPrivilegeList().get(i));
				rpdList.add(rpd);
			}
		}
		
		//更新用户角色（先删除，后添加）
		roleService.updateRolePrivilege(roleId,rpdList);
		
		return "redirect:/role/list";
		
	}
	
	
	

}
