package cs.matemaster.rabbit_book.spring.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author matemaster
 */
@Slf4j
@Component
public class RabbitBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RabbitBook) {
            log.info("bean-name: {}", beanName);
            RabbitBook rabbitBook = (RabbitBook) bean;
            rabbitBook.setName("兔子书");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RabbitBook) {
            log.info("bean-name: {}", beanName);
            RabbitBook rabbitBook = (RabbitBook) bean;
            rabbitBook.setPrice(BigDecimal.TEN);
        }
        return bean;
    }

    @Bean
    public RabbitBook newRabbitBook() {
        return new RabbitBook();
    }
}
