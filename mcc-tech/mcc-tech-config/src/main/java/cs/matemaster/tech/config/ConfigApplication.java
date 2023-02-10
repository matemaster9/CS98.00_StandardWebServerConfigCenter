package cs.matemaster.tech.config;

import cs.matemaster.tech.config.model.AppSystemProperties;
import cs.matemaster.tech.config.model.LoginUserProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * @author matemaster
 */
@Slf4j
@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = {AppSystemProperties.class, LoginUserProperties.class})
public class ConfigApplication {
    public static void main(String[] args) {
//        SpringApplication.run(ConfigApplication.class, args);
        SpringApplication springApplication = new SpringApplication(ConfigApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
