package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/message")
public class Hello {
    @RequestMapping("/index")
    public String indexMethod(){
        return "msgpage";
    }
}
