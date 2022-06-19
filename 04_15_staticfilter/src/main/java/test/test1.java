package test;

import cn.Service.IBookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {

    @Test
    public void testSpring(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IBookService accountService = (IBookService) context.getBean("bookService");

        System.out.println(accountService.findAll());
    }

}
