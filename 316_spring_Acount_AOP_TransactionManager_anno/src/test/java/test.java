import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.service.IAccountService;

public class test {


    @Test
    public void test(){
        ClassPathXmlApplicationContext Context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountServiceImpl = (IAccountService) Context.getBean("accountService");
        accountServiceImpl.transferByName("lisi","ww",100);
        accountServiceImpl.findAll();
    }
}
