package dao;

import domain.Account;
import domain.User;

import java.util.List;

public interface IUserDao {

    User findById(int id);

    List<Account> findAllAccount();

    List<Account> findAccountByUserId(int id);

    List<User> findAllUser();


    void updateUser(User user);




}
