package cs.matemaster.tech.config.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * @author matemaster
 */
@Order(1)
public class LearnApplicationInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {


    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        System.out.println("此spring-boot应用公加载bean：" + beanDefinitionCount + "个");
    }
}
