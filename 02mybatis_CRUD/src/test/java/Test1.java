import dao.IUserDao;

import domain.QueryVo;
import domain.QueryVo1;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test1 {
    private InputStream is;
    private SqlSession session;
    private IUserDao mapper;

    @Before
    public void init() throws Exception{
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        session = factory.openSession();
        mapper = session.getMapper(IUserDao.class);//使用代理对象可以执行
    }

    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        is.close();
    }


    /**
     * select * from mybatis
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        List<User> list = session.selectList("dao.IUserDao.findAll");//直接使用selectList函数
        System.out.println(list);
    }

    @Test
    public void testFindAll(){
        for(User i:mapper.findAll())
        {
            System.out.println(i);
        }
    }


    @Test
    public void testSaveUser() throws Exception {
        User user = new User();
        user.setUsername("lastInsert");
        user.setAddress("北京1");
        user.setBirthday(new Date());
        user.setId(17);
        user.setSex("male");
        System.out.println("保存之前" + user);
        mapper.saveUser(user);
        System.out.println("保存之后" + user);
    }



    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(10);
        user.setUsername("hehe");
        user.setSex("female");
        user.setAddress("上海");
        user.setBirthday(new Date());
        mapper.updateUser(user);
    }

    @Test
    public void deleteUser(){
        mapper.deleteUser(15);
    }

    @Test
    public void testFindById(){
        System.out.println( mapper.findById(14));
    }

    @Test
    public void testFindByName(){
        List<User> users=mapper.findByName("%四%");
        System.out.println(users);
    }




    @Test
    public void testCountId(){
        System.out.println(mapper.findTotal());
    }


    @Test
    public void testFindByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%李%");
        vo.setUser(user);
        System.out.println(mapper.findUserByVo(vo));
    }

    @Test
    public void testfindInIds(){
        QueryVo1 vo1 = new QueryVo1();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(8);
        ids.add(9);
        ids.add(10);
        ids.add(14);
        vo1.setIds(ids);
        List<User> inIds = mapper.findInIds(vo1);
        System.out.println(inIds);
    }
}
