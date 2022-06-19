package com.codebacker.springboot.Controller;

import com.codebacker.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class HelloController {


    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(@RequestParam("user")  String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
       return "Hello World";
    }

    @RequestMapping("/he")
    public String login(){
        return "login";
    }

/*
* th:action="@{/user/login}"*/

    @PostMapping(value="/user/login")
    public String userLogin(@RequestParam("username")  String username, @RequestParam("password") String password, Map<String,Object> map, HttpSession session){

        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            //只有在session域中有了loginUser属性才可以通过过滤器

//            session.setMaxInactiveInterval(10);//session失效时间
            return "redirect:/board";//为啥不直接return "board"
        }else{
            map.put("msg","用户名密码错误");
            return "login";
            /**
             * 这里可以使用重定向保证登录失败刷新页面不会重复提交表格
              */

        }

    }

}
