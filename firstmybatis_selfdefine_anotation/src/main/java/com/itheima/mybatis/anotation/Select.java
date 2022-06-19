package com.itheima.mybatis.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)//出现的位置
public @interface Select {
    /**
     * 配置sql语句的
     */
    String value();
}
