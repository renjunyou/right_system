package right_system;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kdzr.st.right.dao.UserDao;
import com.kdzr.st.right.dto.UserRoleDto;
import com.kdzr.st.right.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml"})
public class UserDaoTest {
	
	@Autowired
	private UserDao ud;
	
	@Test
	public void save() {
		
		User pe = new User();
		pe.setId("1");
		pe.setUsername("用户1");
		pe.setPassword("123");
		
		ud.save(pe);
		
	}
	
	@Test
	public void getAll() {
		
		List<User> plist = new ArrayList<User>();
		
		plist = ud.queryList("1");
		
		for (User p : plist) {
			System.out.println(p.getId()+ "==>" + p.getUsername() + "-->" + p.getPassword());
		}
		
	}
	
	@Test
	public void getRoles() {
		
		List<UserRoleDto> plist = new ArrayList<UserRoleDto>();
		
		plist = ud.getRoles("1");
		
		for (UserRoleDto p : plist) {
			System.out.println(p.getUserid()+ "==>" + p.getUsername() + "-->" + p.getRolename() + "-->" + p.getDescp());
		}
		
	}
	
	@Test
	public void updateRole() {
		
		List<UserRoleDto> plist = new ArrayList<UserRoleDto>();
		UserRoleDto urd1 = new UserRoleDto();
		urd1.setUserid("2");
		urd1.setRoleid("2");
		plist.add(urd1);
		UserRoleDto urd2 = new UserRoleDto();
		urd2.setUserid("2");
		urd2.setRoleid("3");
		plist.add(urd2);
		
		ud.delete("2");
		
		for (UserRoleDto urd : plist) {
			
			ud.updateRole(urd);
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
