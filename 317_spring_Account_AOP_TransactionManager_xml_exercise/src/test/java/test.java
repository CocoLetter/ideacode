import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.service.IAccountService;

public class test {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        try {
            accountService.transferByName("lisi", "ww", 100);
        }finally {
            System.out.println(accountService.findAll());
        }


    }

}
