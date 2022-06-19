package cn.servlet;

import cn.Service.IBookService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class BookServletFindAll extends HttpServlet {

    @Autowired
    IBookService bookService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        IBookService bookService = (IBookService) context.getBean("bookService");
        System.out.println(bookService);
        request.setAttribute("bookList", bookService.findAll());
        System.out.println("book");

        PrintWriter writer = response.getWriter();

        writer.write("hello");
        request.getRequestDispatcher("show.jsp").forward(request,response);
        //总是出现空指针异常，分析其原因是servlet在服务器启动时创建

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }



    public void init() throws ServletException {
        super.init();
        WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getAutowireCapableBeanFactory().autowireBean(this);
    }

}





