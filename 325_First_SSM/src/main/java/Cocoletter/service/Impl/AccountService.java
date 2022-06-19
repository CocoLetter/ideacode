package Cocoletter.service.Impl;

import Cocoletter.dao.IAccountDao;
import Cocoletter.domain.Account;
import Cocoletter.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountService implements IAccountService {

    @Autowired
    IAccountDao dao;//这里要注入mybatis的实现类

    public AccountService(){
        System.out.println("AccountService初始化了");
        System.out.println(this);
    }


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
