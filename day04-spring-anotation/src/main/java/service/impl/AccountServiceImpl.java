package service.impl;


import dao.IAccountDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import service.IAccountService;

/**
 * 账户的业务层实现类
 */

@Component("accountServiceImpl")
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao ;
//
//    public void setAccountDao(IAccountDao accountDao) {
//        this.accountDao = accountDao;
//    }

    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl对象创建了:"+this);
    }

    public void  saveAccount(){
        System.out.println("accountDao"+"保存了Account");
//        accountDao.saveAccount();
    }

    public void  init(){
        System.out.println("AccountServiceImpl对象初始化了。。。");
    }

    public void  destroy(){
        System.out.println("AccountServiceImpl对象销毁了。。。");
    }

}
