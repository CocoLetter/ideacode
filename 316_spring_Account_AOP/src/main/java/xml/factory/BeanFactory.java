package xml.factory;

import xml.Utils.TransactionManager;
import xml.service.IAccountService;

import java.lang.reflect.Proxy;

public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager transactionManager;


    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public IAccountService getAccountService(){
        return (IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), ((proxy, method, args) -> {
            if ("test".equals(method.getName())) {
                return method.invoke(accountService, args);
            }

            Object rtValue = null;
            try {
                //1.开启事务
                transactionManager.beginTransaction();
                //2.执行操作
                rtValue = method.invoke(accountService, args);
                //3.提交事务
                transactionManager.commit();
                //4.返回结果
                return rtValue;
            } catch (Exception e) {
                //5.回滚操作
                transactionManager.rollback();
                throw new RuntimeException(e);
            } finally {
                //6.释放连接
                transactionManager.release();
            }
        }));
    }



}
