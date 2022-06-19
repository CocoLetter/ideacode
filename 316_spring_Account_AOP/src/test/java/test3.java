import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xml.service.IAccountService;


/**
 * 测试：
 * 使用spring aop实现事务控制
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class test3 {

    @Autowired
    @Qualifier("accountService")
    private IAccountService service;

    @Test
    public void test(){
        service.transferByName("lisi","ww",100);

        System.out.println(service.findAll());
    }


}
