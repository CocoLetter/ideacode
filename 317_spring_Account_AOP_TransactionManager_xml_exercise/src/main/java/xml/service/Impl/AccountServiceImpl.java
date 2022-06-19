package xml.service.Impl;

import xml.dao.IAccountDao;
import xml.domain.Account;
import xml.service.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    IAccountDao dao;

    public void setDao(IAccountDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Account> findAll() {
        return dao.findAll();
    }

    @Override
    public void transferByName(String sourceName, String targetName, Integer money) {
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account source = dao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = dao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.5更新转出账户
        dao.updateAccount(source);
        int i=9/0;
        //2.6更新转入账户
        dao.updateAccount(target);

    }
}
