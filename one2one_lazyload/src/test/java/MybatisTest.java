
import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public static void main(String[] args) throws Exception {
        //读取配置文件
        InputStream in= Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建sqlsessionfactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);

        IUserDao userDao = new UserDaoImpl(factory);
        /*
        实现类做的工作定义了userDao的方法
        SqlSession session=factory.openSession();
        List<User> users = session.selectList("com.itheima.dao.IUserDao.findAll");
        */
        //使用代理对象执行方法

        List<User> users = userDao.findAll();
        //使用代理对象执行方法
        for(User user:users){
            System.out.println(user);
        }
        //释放资源
        in.close();
    }
}
