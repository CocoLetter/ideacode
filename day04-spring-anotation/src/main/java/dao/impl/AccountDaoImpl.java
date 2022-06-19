package dao.impl;


import dao.IAccountDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Retention;

/**
 * 账户的持久层实现类
 */
@Component("accountDaoImpl")
public class AccountDaoImpl implements IAccountDao {

    AccountDaoImpl(){
        System.out.println("AccountDaoImpl创建了:"+this);
    }

    public  void saveAccount(){
        System.out.println("AccountDaoImpl保存了账户");
    }

    public void  init(){
        System.out.println("AccountDaoImpl对象初始化了。。。");
    }
    public void  destroy(){
        System.out.println("AccountDaoImpl对象销毁了。。。");
    }

}
