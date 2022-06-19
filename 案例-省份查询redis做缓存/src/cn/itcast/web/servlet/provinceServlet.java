package cn.itcast.web.servlet;

import cn.itcast.domain.Province;
import cn.itcast.service.ProvinceService;
import cn.itcast.service.impl.ProvinceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/provinceServlet")
public class provinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service查询
        ProvinceService service=new ProvinceServiceImpl();
        String json=service.findAllJson();
//        List<Province> list =service.findAll();
        System.out.println(json);
        //序列化list为json
//        ObjectMapper mapper=new ObjectMapper();
//        json=mapper.writeValueAsString(list);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
//        System.out.println("json:"+"\n"+json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}



/*
private void test(){
    ProvinceService service=new ProvinceServiceImpl();
    System.out.println("provinceServlet2");
    List<Province> list =service.findAll();
    System.out.println(list);
}*/
