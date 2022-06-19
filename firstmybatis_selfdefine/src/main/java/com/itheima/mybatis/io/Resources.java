package com.itheima.mybatis.io;

import java.io.InputStream;

/**
* 使用类加载器加载配置文件
*/




/**
 * 解析主配置文件，把里面的内容填充到DefaultSqlSession所需要的地方
 * 使用的技术：
 *      dom4j+xpath
 */
public class Resources {

    public static InputStream getResourceAsStream(String filePath){

        return Resources.class.getClassLoader().getResourceAsStream(filePath);

    }

}
