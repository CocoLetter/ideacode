import dao.IUserDao;

import domain.Account;
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
        List<Account> allAccount = mapper.findAllAccount();
//        System.out.println(allAccount);
    }

    @Test
    public void testFindAccountByUserId(){
        List<User> allUser = mapper.findAllUser();
        for(User i:allUser){
            System.out.println("user:"+i.getId()+"账户-----------------------------------");
            List<Account> accountList = i.getAccountList();

            for(Account j:accountList){
                System.out.println("账户id"+j.getId());
                System.out.println("账户所属user"+j.getUser().getId());
            }
        }
    }



}
