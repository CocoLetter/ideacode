package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        1.导入驱动jar包
//        2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//        3.获取数据库连接对象connection
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydate?serverTimezone=UTC","root","root");
//        4.定义sql语句
        String sql="delete from student2 where id =1";
//        5.获取执行sql语句的对象statement
        Statement stmt=conn.createStatement();

//        6.执行sql，接受返回结果
        int count=stmt.executeUpdate(sql);
//        7.处理结果
        System.out.println(count);
//        8.释放资源
        stmt.close();
        conn.close();
    }
}
