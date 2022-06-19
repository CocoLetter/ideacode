
import com.itheima.dao.IUserDao;
import com.itheima.domain.User;

import com.itheima.mybatis.io.Resources;
import com.itheima.mybatis.sqlsession.SqlSession;
import com.itheima.mybatis.sqlsession.SqlSessionFactory;
import com.itheima.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws Exception {
        InputStream in= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);/*return new DefaultSqlSessionFactory(cfg);*/
        SqlSession session=factory.openSession();/*return new DefaultSqlSession(cfg)*/

        //代理对象
        IUserDao userDao=session.getMapper(IUserDao.class);//接口字节码
//       session.getMapper(IuserDap.class)做的工作就是
//       为userDao接口定义了一个实现类也就是定义了方法findAll() List<User> users = session.selectList("com.itheima.dao.IUserDao.findAll");
        List<User> users = userDao.findAll();
        for(User user:users){
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
