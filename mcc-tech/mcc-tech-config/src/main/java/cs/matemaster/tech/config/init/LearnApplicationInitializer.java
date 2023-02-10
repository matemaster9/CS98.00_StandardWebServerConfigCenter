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
        System.out.println("容器刷新前的bean个数：" + applicationContext.getBeanDefinitionCount());
    }
}
