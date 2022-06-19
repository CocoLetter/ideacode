package xml.service.Impl;

import org.apache.commons.dbutils.handlers.BeanHandler;
import xml.Utils.TransactionManager;
import xml.dao.IAccountDao;
import xml.domain.Account;
import xml.service.IAccountService;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

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

        try {
            txManager.beginTransaction();

            Account source = accountDao.findUserByName(user1);

            Account target = accountDao.findUserByName(user2);

            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);

            accountDao.update(source);

            accountDao.update(target);

            txManager.commit();
        }catch(Exception e){
            txManager.rollback();
            e.printStackTrace();
        }finally {
            txManager.release();
        }

    }

}
