package cn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloController {

    @RequestMapping(value="/hello",method = RequestMethod.GET,params = "username=heihei",headers = "Accept")/*方法访问方式,以及访问时要带的参数，如果且参数值必须为heihei*/
    public String sayHello() {
        System.out.println("hello String MVC");
        return "success";
    }
}


