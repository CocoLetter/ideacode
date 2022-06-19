package com.itheima.controller;


import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    IAccountService service;


    @RequestMapping("/findall")
    public String findAll(Model model){
        System.out.println("Controller运行");
        List<Account> list = service.findAll();
        Account Account= list.get(0);
        model.addAttribute("Account",Account);
        System.out.println(list);
        return "success";//这里可能必须要跳转页面 不能返回List<Account>
    }


    @RequestMapping("/saveAccount")
    public void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("Controller运行");
        service.saveAccount(account);

        response.sendRedirect(request.getContextPath()+"/account/findall");
    }

}
