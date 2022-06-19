package com.codebacker.springbootmysql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringBootMysqlApplicationTests {

    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    Beantest beantest;


    @Test
    void contextLoads() throws SQLException {
        System.out.println(beantest);
        System.out.println(datasource.getClass());
        Connection connection = datasource.getConnection();
//        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from account");
//        System.out.println(connection);
//        System.out.println(list.get(0));
    }

}
