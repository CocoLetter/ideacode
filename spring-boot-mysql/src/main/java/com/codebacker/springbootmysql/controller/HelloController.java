package com.codebacker.springbootmysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    @ResponseBody
    public Map<String,Object> map(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from account");
        return list.get(2);
    }
    @GetMapping("/hello1")
    @ResponseBody
    public Map<String,Object> map1(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from account where id = 4 ");
        return list.get(0);
    }




}
