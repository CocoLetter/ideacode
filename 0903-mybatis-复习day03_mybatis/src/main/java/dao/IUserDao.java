package dao;

import domain.QueryVo;
import domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    @Select("select * from mybatis")
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
    List<User> findById(int id);
    List<User> findByName(String str);
    int findTotal();
    List<User> findUserByVo(QueryVo vo);
    List<User> findByUser(User user);

}