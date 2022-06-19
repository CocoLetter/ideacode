package cn.user.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    static{
        try {
            //读取资源文件
            Properties pro=new Properties();
            //classLoader
            ClassLoader classloader=JDBCUtils.class.getClassLoader();

            URL res = classloader.getResource("jdbc.properties");
            String res1=res.getPath();
            System.out.println(res1);

            pro.load(new FileReader(res1));
            //获取数据
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            url=pro.getProperty("url");
            driver=pro.getProperty("driver");
            //注册驱动
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }


    public static void close(Statement stmt,Connection con){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
//      释放资源
    public static void close(ResultSet rs,Statement stmt,Connection con){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
