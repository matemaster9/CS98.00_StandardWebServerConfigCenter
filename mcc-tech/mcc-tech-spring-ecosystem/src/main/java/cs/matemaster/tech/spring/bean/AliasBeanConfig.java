package cs.matemaster.tech.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author matemaster
 */
@Configuration
public class AliasBeanConfig {

    @Bean({"alias1", "alias2"})
    public String alias() {
        return "Alias";
    }
}
