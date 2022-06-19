import com.ssm.chapter13.pojo.Role;
import com.ssm.chapter13.service.RoleListService;
import com.ssm.chapter13.service.RoleService;
import com.ssm.chapter13.service.impl.RoleListServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Chapter13Main {
	public static void main(String [] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext ("spring-cfg.xml");
//		RoleListService roleListService = (RoleListService) ctx.getBean(RoleListService.class);
        RoleService roleListService = (RoleService) ctx.getBean("roleServiceImpl");

		List<Role> roleList = new ArrayList<Role>();
        for (int i=1; i<=2; i++) {
            Role role = new Role();
            role.setRoleName("role_name_" + i);
            role.setNote("note_" + i);
            roleList.add(role);
        }
        int count = roleListService.insertRoleList2(roleList);
	   System.out.println(count);
	}
}