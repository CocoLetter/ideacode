package cn.user.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtilsDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt=null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //4.定义sql语句
            String sql = " insert into student2(id,name,score,insert_time,gender,age) values(1,'张生',89,null,'female',19);";
            //5.获取执行sql语句的对象statement
            stmt = conn.createStatement();
            //6.执行sql，接受返回结果
            int count = stmt.executeUpdate(sql);
            //7.处理结果
            System.out.println(count);
            //8.释放资源
        }finally {
            JDBCUtils.close(stmt,conn);
        }
    }
}
