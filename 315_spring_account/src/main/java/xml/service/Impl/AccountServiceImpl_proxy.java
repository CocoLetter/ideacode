package xml.service.Impl;

import xml.dao.IAccountDao;
import xml.domain.Account;
import xml.service.IAccountService;

import java.util.List;

public class AccountServiceImpl_proxy implements IAccountService {

    private IAccountDao accountDao;


    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public void delete(Integer id) {
        accountDao.delete(id);
    }


    public void transferByName(String user1, String user2, Integer money) {

            Account source = accountDao.findUserByName(user1);
            Account target = accountDao.findUserByName(user2);

            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);

            accountDao.update(source);
            accountDao.update(target);

    }
}
