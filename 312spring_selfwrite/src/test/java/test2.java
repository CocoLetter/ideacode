import annotation.domain.Account;
import annotation.service.IAccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class test2 {

        private IAccountService service;

        @Test
        public void testFindAll(){

            ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
            service  = (IAccountService)ac.getBean("accountServiceImpl");
            List<Account> all = service.findAll();
            System.out.println(all);
            ac.close();
        }

}
