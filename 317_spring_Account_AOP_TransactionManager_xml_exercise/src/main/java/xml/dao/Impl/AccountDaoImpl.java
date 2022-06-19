package xml.dao.Impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import xml.dao.IAccountDao;
import xml.domain.Account;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> query = super.getJdbcTemplate().query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class),accountId);

        return query.isEmpty()?null:query.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> query = super.getJdbcTemplate().query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class),accountName);

        if(query.isEmpty()){
            return null;
        }
        if(query.size()>1){
            throw new RuntimeException("查询结果不唯一");
        }

        return query.get(0);
    }

    @Override
    public void updateAccount(Account account) {

        super.getJdbcTemplate().update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());

    }

    @Override
    public List<Account> findAll() {

        List<Account> query = super.getJdbcTemplate().query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));

        return query;
    }

}
