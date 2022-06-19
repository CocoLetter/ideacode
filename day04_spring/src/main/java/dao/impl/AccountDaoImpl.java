package dao.impl;


import dao.IAccountDao;

/**
 * 账户的持久层实现类
 */
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
