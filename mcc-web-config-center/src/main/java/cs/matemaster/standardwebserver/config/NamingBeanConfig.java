package cs.matemaster.standardwebserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author matemaster
 */
@Configuration
public class NamingBeanConfig {

    /**
     * bean的默认命名规则，当首字母和第二个字母大写时，容器将保留原名，不在使用默认小驼峰命名
     * @return
     */
    @Bean
    public String NAmingBean() {
        return "NamingBeanConfig";
    }
}
