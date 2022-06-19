package xml.Config;


import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("xml")
@Import({JdbcConfig.class,TransactionManager.class})
@PropertySource("jdbc.properties")
@EnableTransactionManagement
public class SpringConfig {
}

