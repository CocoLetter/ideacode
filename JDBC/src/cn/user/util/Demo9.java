package cn.user.util;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入用户名");
        String user=sc.nextLine();
        System.out.println("输入密码");
        String password=sc.nextLine();
        boolean flag=login2(user,password);
        if (flag==true){
            System.out.println("登录成功");
        }else{
            System.out.println("用户密码错误");
        }

    }

    public static boolean login(String user,String password){
        if(user==null||password==null){
            return false;
        }else{
            Connection conn=null;
            Statement stmt=null;
            ResultSet rs=null;
            try {
                conn=JDBCUtils.getConnection();
                String sql="select * from login where name='"+user+"' and password='"+password+"';";
                System.out.println(sql);
                stmt=conn.createStatement();
                rs=stmt.executeQuery(sql);
                return rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.close(rs,stmt,conn);
            }
        }
        return false;
    }

    //使用预编译
    public static boolean login2(String user,String password){
        if(user==null||password==null){
            return false;
        }else{
            Connection conn=null;
            PreparedStatement stmt=null;
            ResultSet rs=null;
            try {
                conn=JDBCUtils.getConnection();
                String sql="select * from login where name=? and password=?;";
                stmt=conn.prepareStatement(sql);
                stmt.setString(1,user);
                stmt.setString(2,password);
                rs=stmt.executeQuery();
                return rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.close(rs,stmt,conn);
            }
        }
        return false;
    }
}
