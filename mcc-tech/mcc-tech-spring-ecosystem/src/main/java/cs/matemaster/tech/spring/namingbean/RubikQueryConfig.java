package cs.matemaster.tech.spring.namingbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author matemaster
 */
@Configuration
public class RubikQueryConfig {

    @Bean
    public static String staticFactoryMethod() {
        return "staticFactoryMethod";
    }

    @Bean
    public String instanceFactoryMethod() {
        return "instanceFactoryMethod";
    }

    @Bean("SpecificNamingBean")
    public String namingBean() {
        return "namingBean";
    }
}
