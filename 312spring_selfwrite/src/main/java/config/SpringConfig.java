package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan("annotation")
@Import(JdbcConfig.class)
public class SpringConfig {

}


