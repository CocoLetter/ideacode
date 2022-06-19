package xml.service.Impl;

import org.springframework.transaction.support.TransactionTemplate;
import xml.dao.IAccountDao;
import xml.domain.Account;
import xml.service.IAccountService;

import java.util.List;

public class AccountServiceImpl_proxy implements IAccountService {

    private IAccountDao accountDao;
    private TransactionTemplate transactionTemplate;


    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public Account findAccountById(Integer accountId) {
        return null;
    }

    @Override
    public void findAll() {

    }

    @Override
    public void transferByName(String sourceName, String targetName, Integer money) {

    }
}
