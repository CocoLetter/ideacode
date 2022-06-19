package test;

import Cocoletter.dao.IAccountDao;
import Cocoletter.domain.Account;
import Cocoletter.service.IAccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {

    @Test
    public void testSpring(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService");

        accountService.findAll();
    }

}
