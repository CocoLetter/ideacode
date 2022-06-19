
import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public static void main(String[] args) throws Exception {
        InputStream in= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession session=factory.openSession();
        IUserDao userDao=session.getMapper(IUserDao.class);
/*
session.getMapper(IuserDap.class)做的工作就是
为userDao接口定义了一个实现类也就是定义了方法findAll() List<User> users = session.selectList("com.itheima.dao.IUserDao.findAll");
*/
        List<User> users = userDao.findByName("%l%");
//        List<User> users = userDao.findAll();

        for(User user:users){
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
