package com.Utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 获取线程连接
 * 请理线程连接
 */

public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    /**
     * 获取连接
     */
    public Connection getThreadConnection() throws SQLException {
        try {
            Connection connection = tl.get();

            if (connection == null) {
                connection = dataSource.getConnection();
                tl.set(connection);
            }
            return connection;

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void removeConnection(){
        tl.remove();
    }

}
