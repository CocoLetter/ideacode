package cn.user.util;

import java.sql.*;
import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt1 = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            String sql = "update account set balance=balance+? where id =?;";
            String sql1 = "update account set balance=balance-? where id =?;";
            System.out.println(sql);
            System.out.println(sql1);
            stmt = conn.prepareStatement(sql);
            stmt1 = conn.prepareStatement(sql1);
            stmt.setInt(1, 500);
            stmt.setInt(2, 1);
            stmt1.setInt(1, 500);
            stmt1.setInt(2, 2);
            System.out.println(3 / 0);
            stmt1.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                if(conn!=null){
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt, null);
            JDBCUtils.close(stmt, conn);
        }
    }
}

