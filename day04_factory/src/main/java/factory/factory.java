package factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class factory {
    private static Properties properties;
    private static Map<String, Object> map;


    static{
        try {
            properties = new Properties();
            InputStream in = factory.class.getClassLoader().getResourceAsStream("bean.properties");

            properties.load(in);

            //实例化容器
            map = new HashMap<String, Object>();

            //取出配置文件中的所有keys
            Enumeration keys = properties.keys();

            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanPath = properties.getProperty(key);

                Object value = Class.forName(beanPath).newInstance();
                map.put(key, value);
            }
        }catch(Exception e){
            throw new ExceptionInInitializerError("初始化错误");
        }
    }

    public static Object getBean(String beanName){
        return map.get(beanName);
    }

}
