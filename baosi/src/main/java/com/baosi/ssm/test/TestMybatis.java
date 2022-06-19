package com.baosi.ssm.test;


import com.baosi.ssm.dao.IUserDao;
import com.baosi.ssm.service.IUserService;
import com.baosi.ssm.service.impl.ImageSlideServiceImpl;
import com.baosi.ssm.service.impl.RoleServiceImpl;
import com.baosi.ssm.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestMybatis {
    @Autowired
    IUserDao userDao;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    ImageSlideServiceImpl slideService;
    @Test
    public void testFindAll() throws Exception {
        System.out.println(slideService.findById(1));
    }


}
