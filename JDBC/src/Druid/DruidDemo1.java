package Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        Properties pro =new Properties();
        InputStream is = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        DataSource ds= DruidDataSourceFactory.createDataSource(pro);
        int i =0;
        while(i<10){
            i++;
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);
        }
    }
}
