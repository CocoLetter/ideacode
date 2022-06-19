package cn.controller;


import cn.domain.Account;
import cn.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

//*
// * 请求参数绑定


@Controller
@RequestMapping("/param")
public class ParamController {

//*
//     * 请求参数绑定入门
//     * @return


    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("执行了...");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        return "success";
    }

//*
//     * 请求参数绑定把数据封装到JavaBean的类中
//     * @return
//

    @RequestMapping("/saveAccount")
    public String saveAccount(@Valid Account account, Errors errors, Model model, ModelMap modelmap, ModelAbndView modelandview) {
        System.out.println(account);
        // 是否存在错误
        if (errors.hasErrors()) {
            // 获取错误信息
            List<FieldError> errorList = errors.getFieldErrors();
            for (FieldError error : errorList) {
                // 打印字段错误信息
                System.out.println("fied :" + error.getField() + "\t" + "msg:" + error.getDefaultMessage());
            }
        }
        return "success";
    }

//*
//     * 自定义类型转换器
//     * @param user
//     * @return
//

    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("执行了...");
        System.out.println(user);
        return "success";
    }

//*
//     * 原生的API
//     * @return


    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了...");
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);
        return "success";
    }


    @RequestMapping("/useRequestBody")
    public String useRequestBody(@RequestBody String param){
        System.out.println(param);
//        System.out.println(password);
//        System.out.println(age);
        return "success";
    }

}
