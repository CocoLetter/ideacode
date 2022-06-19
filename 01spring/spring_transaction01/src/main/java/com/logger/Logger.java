package com.logger;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.Utils.TransactionManager;

/**
 * 切面控制AOP
 */
@Component("logger")
@Aspect
public class Logger {

    @Autowired
    private TransactionManager transactionManager;


    @Pointcut("execution(* com.service.Impl.*.*(..))")
    private void pt(){}


    @Around("pt()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();//得到方法执行所需的参数

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。前置");
            //1.开启事务
            transactionManager.beginTransaction();

            //2.执行操作
            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。后置");
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return rtValue;
        }catch (Throwable t){
            transactionManager.rollback();
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。异常");
            throw new RuntimeException(t);

        }finally {
            transactionManager.release();
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。.最终");
        }
    }


}
