package cs.matemaster.tech.config;

import cs.matemaster.tech.config.init.LearnApplicationInitializer;
import cs.matemaster.tech.config.init.LearnApplicationListener;
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

        /**
         * <p>
         * SpringBootApplication静态方法启动
         * SpringApplication.run(ConfigApplication.class, args);
         * </p>
         */

        // 创建SpringApplication实例
        SpringApplication springApplication = new SpringApplication(ConfigApplication.class);

        // 关闭banner
        springApplication.setBannerMode(Banner.Mode.OFF);

        // 加入ApplicationContextInitializer、ApplicationListener实例
        springApplication.addInitializers(new LearnApplicationInitializer());
        springApplication.addListeners(new LearnApplicationListener());

        // 启动应用
        springApplication.run(args);

        /** SpringApplicationBuilder启动
         *
         *  SpringApplicationBuilder builder = new SpringApplicationBuilder(ConfigApplication.class);
         *  builder.bannerMode(Banner.Mode.OFF)
         *         .initializers(new LearnApplicationInitializer())
         *         .listeners(new LearnApplicationListener())
         *         .run(args);
         *
         */


    }
}
