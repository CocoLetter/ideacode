package xml.dao;

import xml.domain.Account;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有
     * @return
     */

    List<Account> findAll();
    /**
     * id查询
     */

    Account findById(Integer id);

    /**
     * 保存
     */
    void saveAccount(Account account);

    /**
     * 更新
     */

    void update(Account account);

    /**
     * 删除
     */

    void delete(Integer id);

    public Account findUserByName(String username);

}
