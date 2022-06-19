package cn.itcast.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;

public class JDBCUtils {
    //1.定义成员变量
    private static DataSource ds;
    static{
        try {
            //加载配置文件
            Properties pro =new Properties();
            pro.load(Objects.requireNonNull(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties")));
            //获取datasource
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接的方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    //释放资源
    public static void close(Statement stmt,Connection conn){
        close(null,stmt,conn);

    }

    public static void close(ResultSet rs, Statement stmt, Connection conn){
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
        if(conn!=null){
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }
}
