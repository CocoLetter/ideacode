import dao.IUserDao;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test2 {

    private InputStream is;
    private SqlSessionFactory factory;

    @Before
    public void init() throws Exception{
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory= builder.build(is);
    }


    @Test
    public void testFirstLevelCache() throws IOException {

        SqlSession session1 = factory.openSession();
        IUserDao   mapper1=session1.getMapper(IUserDao.class);
        User byId = mapper1.findById(14);
        System.out.println(byId);
        User byId2 = mapper1.findById(14);
        System.out.println(byId2);
        session1.close();
        is.close();
    }

    @Test
    public void testFirstLevelCache1(){
        SqlSession session1 = factory.openSession();
        IUserDao   mapper1=session1.getMapper(IUserDao.class);

        User user1 = mapper1.findById(14);
        System.out.println(user1);

        User user16 = mapper1.findById(16);

        //session.close()或者session.clearCache()都会请理缓存

        //2.更新用户信息
        user16.setUsername("update user clear cache");
        user16.setAddress("北京市海淀区");
        mapper1.updateUser(user16);

        //3.再次查询id为41的用户
        User user2 = mapper1.findById(14);
        System.out.println(user2);

        System.out.println(user1 == user2);

    }

    @Test
    public void testSecondLevelCache(){
        SqlSession sqlSession1 = factory.openSession();
        IUserDao dao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = dao1.findById(14);
        System.out.println(user1);
        User user16 = dao1.findById(16);
        //session.close()或者session.clearCache()都会请理缓存
        //2.更新用户信息
        user16.setUsername("update user clear cache");
        user16.setAddress("北京市海淀区");
        dao1.updateUser(user16);

        sqlSession1.close();//一级缓存消失
        SqlSession sqlSession2 = factory.openSession();
        IUserDao dao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = dao2.findById(16);
        System.out.println(user2);
        sqlSession2.close();
    }
}


