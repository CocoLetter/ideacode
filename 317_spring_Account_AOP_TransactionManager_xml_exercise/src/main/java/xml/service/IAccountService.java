package xml.service;

import xml.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    void transferByName(String sourceName,String targetName,Integer money);

}
