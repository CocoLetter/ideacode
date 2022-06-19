package com.user.check;


import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class userNameCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Map<String,Object> map=new HashMap<String,Object>();
        System.out.println("findUserServlet");
        if("tom".equals(username)){
            map.put("userExit",true);
            map.put("msg","名字太受欢迎了，请换一个名字");
            System.out.println("tom");
        }else{

            map.put("userExit",false);
            map.put("msg","成功");
            System.out.println(" not tom");
            System.out.println(map);

        }
        response.setContentType("application/json;charset=utf-8");

        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
