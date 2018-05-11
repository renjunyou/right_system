package right_system;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kdzr.st.right.dao.RoleDao;
import com.kdzr.st.right.dto.RolePrivilegeDto;
import com.kdzr.st.right.model.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml"})
public class RoleDaoTest {
	
	@Autowired
	private RoleDao rd;
	
	@Test
	public void save() {
		
		Role pe = new Role();
		pe.setId("1");
		pe.setName("角色1");
		pe.setDescription("角色1描述");
		
		rd.save(pe);
		
	}
	
	@Test
	public void getAll() {
		
		List<Role> plist = new ArrayList<Role>();
		
		plist = rd.queryList("1");
		
		for (Role p : plist) {
			System.out.println(p.getId()+ "==>" + p.getName() + "-->" + p.getDescription());
		}
		
	}
	
	@Test
	public void getPrivilege() {
		
		List<RolePrivilegeDto> plist = new ArrayList<RolePrivilegeDto>();
		
		plist = rd.getPrivileges("2");
		
		for (RolePrivilegeDto r : plist) {
			System.out.println(r.getRoleid() + "-->" + r.getRolename() + "-->" + r.getPrivilegename() + "-->" + r.getPrivilegedesc());
		}
		
		//https://www.imooc.com/article/24225
		
	}
	
	@Test
	public void addPrivilege() {
		
		List<RolePrivilegeDto> plist = new ArrayList<RolePrivilegeDto>();
		
		rd.delete("2");
		
		RolePrivilegeDto rpd1 = new RolePrivilegeDto();
		rpd1.setRoleid("1");
		rpd1.setPrivilegeid("3");
		RolePrivilegeDto rpd2 = new RolePrivilegeDto();
		rpd2.setRoleid("1");
		rpd2.setPrivilegeid("4");
		
		plist.add(rpd1);
		plist.add(rpd2);
		
		for (RolePrivilegeDto rdt : plist) {
			rd.addPrivilege2Role(rdt);
		}
		
		
	}
	
	
	
	
	
	
	

}
