import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xml.Config.SpringConfig;
import xml.service.IAccountService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringConfig.class)
public class test {


    @Autowired
    IAccountService accountServiceImpl;

    @Test
    public void test(){

        try{
            accountServiceImpl.transferByName("lisi","ww",100);
        }finally {
            accountServiceImpl.findAll();
        }
    }
}
