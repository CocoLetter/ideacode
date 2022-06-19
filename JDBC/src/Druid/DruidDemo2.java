package Druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DruidDemo2 {
    //给account表添加一条记录
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement stmt=null;

        try{
            conn=JDBCUtils.getConnection();
            String sql="insert into account values(null,?,?);";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,"lisheng");
            stmt.setInt(2,2000);
            int num = stmt.executeUpdate();
            System.out.println(num);
        }finally{
            //释放资源
                JDBCUtils.close(stmt,conn);
        }
    }
}
