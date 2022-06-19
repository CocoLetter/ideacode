package impl;

import dao.IUserDao;
import domain.QueryVo;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserImpl implements IUserDao {
    SqlSessionFactory factory;
    public UserImpl(SqlSessionFactory factory){
        this.factory=factory;
    }

    @Override
    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> list = session.selectList("dao.IUserDao.findAll");
        session.close();
        return list;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public List<User> findById(int id) {
        return null;
    }

    @Override
    public List<User> findByName(String str) {
        return null;
    }

    @Override
    public int findTotal() {
        return 0;
    }

    @Override
    public List<User> findUserByVo(QueryVo vo) {
        return null;
    }

    @Override
    public List<User> findByUser(User user) {
        return null;
    }
}
