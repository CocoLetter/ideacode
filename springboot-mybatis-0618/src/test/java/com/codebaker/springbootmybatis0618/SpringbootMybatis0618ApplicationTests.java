package com.codebaker.springbootmybatis0618;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootMybatis0618ApplicationTests {

    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;



    @Test
    void contextLoads() throws SQLException {
        System.out.println(datasource.getClass());
        Connection connection = datasource.getConnection();
//        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from account");
//        System.out.println(connection);
//        System.out.println(list.get(0));
    }


}



class Solution3{
    public void solution(int k, int num1,int num2,int num3){
        int root = Math.(2,k-1);
        int base = 0;
        while(num1>root){
            base += root;
            num1 -= root;
            num2 -= root;
            num3 -= root;
            root /= 2;
        }
        while(root>num3){
            root /= 2;
        }
        int res = root + base;
    }
}







