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
import java.util.Date;
import java.util.List;

public class test {
    InputStream rs;
    SqlSession sqlSession;
    IUserDao mapper;
    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        rs = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = factoryBuilder.build(rs);
        sqlSession = build.openSession();
        mapper = sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        rs.close();
    }

    @Test
    public void testUpdate(){
        /*
        User user = new User();
        user.setId(57);
        user.setUsername("mybatis annotation update");
        user.setAddress("北京市海淀区");
        user.setSex("男");
        user.setBirthday(new Date());

        List<User> all = mapper.findAll();
        System.out.println(all);


        mapper.saveUser(user);

        mapper.findById(14);

        mapper.deleteUser(57);
        mapper.findUserByName("李");

        System.out.println(mapper.findTotalUser());
*/
        List<User> all = mapper.findAll();
        System.out.println(all);


    }


}
