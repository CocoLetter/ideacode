package xml.service;


import xml.domain.Account;

public interface IAccountService {


    /**
     * 根据id查询账户信息
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    void findAll();


    void transferByName(String sourceName, String targetName, Integer money);

}
