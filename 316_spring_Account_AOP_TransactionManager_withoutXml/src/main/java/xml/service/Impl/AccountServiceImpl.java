package xml.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xml.dao.IAccountDao;
import xml.domain.Account;
import xml.service.IAccountService;


@Component("accountService")
@Transactional(readOnly =true, propagation = Propagation.SUPPORTS)
public class AccountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier("accountDao")
    private IAccountDao accountDao;

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void findAll() {
        System.out.println(accountDao.findAll());
    }

    @Transactional(readOnly =false, propagation = Propagation.REQUIRED)
    @Override
    public void transferByName(String sourceName, String targetName, Integer money) {
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.5更新转出账户
        accountDao.updateAccount(source);
        int i=9/0;
        //2.6更新转入账户
        accountDao.updateAccount(target);
    }
}
