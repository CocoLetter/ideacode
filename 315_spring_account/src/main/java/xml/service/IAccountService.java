package xml.service;

import org.apache.commons.dbutils.handlers.BeanHandler;
import xml.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountService {



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


    /**
     * 转账
     */
    public void transferByName(String user1, String user2, Integer money) ;

}
