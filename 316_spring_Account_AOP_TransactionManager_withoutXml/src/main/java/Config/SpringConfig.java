package Config;


import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("xml")//默认是扫描当前路径 当前是扫描xml包中的component
@PropertySource("jdbc.properties")
@Import({JDBCConfig.class,TransactionManagerConfig.class})
@EnableTransactionManagement
public class SpringConfig {
    //要想使用@Value 用${}占位符注入属性，这个bean是必须的，这个就是占位bean,另一种方式是不用value直接用Envirment变量直接getProperty('key')
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
