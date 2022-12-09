package cs.matemaster.tech.config;

import cs.matemaster.tech.config.model.AppSystemProperties;
import cs.matemaster.tech.config.model.LoginUserProperties;
import cs.matemaster.tech.config.model.RandomValueProperties;
import cs.matemaster.tech.config.model.WebServerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author matemaster
 */
@Slf4j
@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = {AppSystemProperties.class, LoginUserProperties.class})
public class ConfigApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConfigApplication.class, args);
        WebServerProperties webServerProperties = configurableApplicationContext.getBean(WebServerProperties.class);
        RandomValueProperties randomValueProperties = configurableApplicationContext.getBean(RandomValueProperties.class);
        AppSystemProperties appSystemProperties = configurableApplicationContext.getBean(AppSystemProperties.class);
        LoginUserProperties loginUserProperties = configurableApplicationContext.getBean(LoginUserProperties.class);

        log.info(webServerProperties.toString());
        log.info(randomValueProperties.toString());
        log.info(appSystemProperties.toString());
        log.info(loginUserProperties.toString());

        for (String beanDefinitionName : configurableApplicationContext.getBeanDefinitionNames()) {
            log.info(beanDefinitionName);
        }
    }
}
