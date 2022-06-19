
import org.junit.Test;

import java.sql.*;

public class test {

    @Test
    public void test() throws ClassNotFoundException, SQLException {
        //加载数据库驱动
        Class.forName("");
        //得到Connection连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@107.0.0.1:1521:orcl", "scott", "tiger");
        //得到预编译的Statement对象
        PreparedStatement pstm = connection.prepareStatement("select * from emp where empno = ?");
        //给参数赋值
        pstm.setObject(1, 7788);
        //执行数据库查询操作
        ResultSet rs = pstm.executeQuery();
        //输出结果
        while(rs.next()){
            System.out.println(rs.getString("ename"));
        }
        //释放资源
        rs.close();
        pstm.close();
        connection.close();
    }
}
