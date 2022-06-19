import com.pojo.Account;
import com.service.IAccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test01 {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService");

//        accountService.transfer("lisi","ww",100f);
        List<Account> allAccount = accountService.findAllAccount();
        System.out.println(allAccount);

    }
}

/*[Account{id=4, name='lisi', money=-400}, Account{id=5, name='ww', money=2300}, Account{id=6, name='hello', money=8788}, Account{id=7, name='hello', money=1567}, Account{id=16, name='hello', money=1000}, Account{id=17, name='hello', money=1000}, Account{id=18, name='hello', money=8788}, Account{id=19, name='hello', money=1567}, Account{id=20, name='liubao', money=100}, Account{id=21, name='liubao', money=100}, Account{id=22, name='liubao', money=100}]
 */