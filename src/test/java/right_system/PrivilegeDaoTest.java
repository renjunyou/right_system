package right_system;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kdzr.st.right.dao.PrivilegeDao;
import com.kdzr.st.right.model.Privilege;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml"})
public class PrivilegeDaoTest {
	
	@Autowired
	private PrivilegeDao ped;
	
	@Test
	public void save() {
		
		Privilege pe = new Privilege();
		pe.setId("1");
		pe.setName("administrator");
		pe.setDescription("管理员");
		
		ped.save(pe);
		
	}
	
	@Test
	public void getAll() {
		
		List<Privilege> plist = new ArrayList<Privilege>();
		
		plist = ped.queryList("1");
		
		for (Privilege p : plist) {
			System.out.println(p.getId()+ "==>" + p.getName() + "-->" + p.getDescription());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
