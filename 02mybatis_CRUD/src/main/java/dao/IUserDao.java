package dao;

import domain.QueryVo;
import domain.QueryVo1;
import domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
    List<User> findById(int id);
    List<User> findByName(String str);
    int findTotal();
    List<User> findUserByVo(QueryVo vo);
    List<User> findInIds(QueryVo1 vo1);
}
