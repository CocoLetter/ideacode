
import com.itheima.dao.IUserDao;
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
        InputStream in= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession session=factory.openSession();
        IUserDao userDao=session.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        for(User user:users){
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
