package xml.dao.impl;

import xml.Utils.ConnectionUtils;
import xml.dao.IAccountDao;
import xml.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }


    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAll() {
        try {
            return (List<Account>)runner.query(connectionUtils.getThreadConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findById(Integer id) {
        try {
            return (Account) runner.query(connectionUtils.getThreadConnection(),"select * from account where id = ? ", new BeanHandler(Account.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"insert into account(name,money) values(?,?)", account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"update account set name=?,money=? where id =?", account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(Integer id) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"delete from account where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public Account findUserByName(String username){
        try {
            List<Account> query =  runner.query(connectionUtils.getThreadConnection(), "select * from account where name = ? ", new BeanListHandler<Account>(Account.class), username);
            if(query==null||query.size()==0){
                throw new RuntimeException("Account查询结果为0");
            }
            if(query.size()>1){
                throw new RuntimeException("Account查询结果不唯一");
            }
            return query.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
