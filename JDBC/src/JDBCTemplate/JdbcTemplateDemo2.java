package JDBCTemplate;

import Druid.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {
    private static  JdbcTemplate template= new JdbcTemplate(JDBCUtils.getDataSource());


    public static void main(String[] args) {
        //修改一条数据
        /*String sql="update temp set salary=500 where id =?;";
        int count  = template.update(sql,5000);
        System.out.println(count);*/
        //添加一条记录
        /*String sql="insert into temp(name,salary) values('liming',?);";
        int count  = template.update(sql,5000);
        System.out.println(count);
        //删除刚才添加的记录
        String sql1 ="delete from temp where name=?;";
        int count1=template.update(sql1,"zhangsan");
        System.out.println(count1);*/

        /*String sql1 ="select * from temp where id =?";
        Map<String, Object> map = template.queryForMap(sql1, 2);
        System.out.println(map);
        */
        //queryForList()
        /* String sql1 ="select * from temp where id =? or id =?";
        List<Map<String, Object>> maps = template.queryForList(sql1, 2, 4);
        System.out.println(maps);*/
        //查询所有记录,将器封装为Emp对象的List集合
/*        String sql="select * from temp;";
        List<Temp> list =template.query(sql,new BeanPropertyRowMapper<Temp>(Temp.class));
        for(Temp emp:list){
            System.out.println(emp);
        }*/
        String sql="select count(id) from temp;";
        Long total = template.queryForObject(sql,Long.class);
        System.out.println(total);
    }



    public void test(){
        JdbcTemplate template= new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="update temp set salary=500 where id =?;";
        int count  = template.update(sql,5000,1);
        System.out.println(count);
    }
}
