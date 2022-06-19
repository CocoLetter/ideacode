package dao;

import domain.*;

import java.util.List;

public interface IUserDao {

    List<Account> findAccount();

    List<UserWithAccount> findUser();

    List<User> findRole();

}
