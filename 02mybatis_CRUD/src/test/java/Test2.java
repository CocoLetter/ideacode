import impl.UserImpl;
import domain.User;
import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Test2 {

    @Test
    public void testFindAll() throws Exception {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder factoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = factoryBuilder.build(is);
        UserImpl user = new UserImpl(factory);
        List<User> list = user.findAll();
        System.out.println(list);
    }
}
