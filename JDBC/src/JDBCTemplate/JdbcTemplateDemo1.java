package JDBCTemplate;

import Druid.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template= new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="update account set balance =? where id = ?;";
        //3.调用方法
        int count=template.update(sql,5000,1);
        System.out.println(count);

    }
}
