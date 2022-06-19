package service.impl;

import dao.IUserDao;

import factory.factory;
import service.IAccountService;

public class AccountServiceImpl implements IAccountService {


    private IUserDao accountDao = (IUserDao)factory.getBean("IUserDao");


    public void findAll() {
        accountDao.findAll();
    }
}
