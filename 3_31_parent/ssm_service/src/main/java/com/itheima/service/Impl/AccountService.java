package com.itheima.service.Impl;


import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itheima.service.IAccountService;

import java.util.List;

@Service("accountService")
public class AccountService implements IAccountService {

    @Autowired
    IAccountDao dao;//这里要注入mybatis的实现类

    // 查询所有账户
    public List<Account> findAll(){
        System.out.println("service运行了");
        return dao.findAll();
    }

    // 保存帐户信息
    public void saveAccount(Account account){
        dao.saveAccount(account);
    }

}
