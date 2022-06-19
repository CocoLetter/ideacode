package annotation.service.Impl;

import annotation.dao.IAccountDao;
import annotation.domain.Account;
import annotation.service.IAccountService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import java.util.List;




@Service("accountServiceImpl")
@Scope("prototype")
public class AccountServiceImpl implements IAccountService {


    @Resource(name = "AccountDaoImpl")
    private IAccountDao accountDao;

    @PostConstruct
    public void init(){
        System.out.println("AccountServiceImpl初始化方法执行了");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("AccountServiceImpl销毁");
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
}
