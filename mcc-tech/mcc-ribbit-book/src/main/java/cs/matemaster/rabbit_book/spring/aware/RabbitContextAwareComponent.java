package cs.matemaster.rabbit_book.spring.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * implements ApplicationContextAware 完成bean对容器的感知
 * @author matemaster
 */
@Slf4j
@Component
public class RabbitContextAwareComponent implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public void printContextDisplayNameToConsole() {
        String displayName = context.getDisplayName();
        log.info("ContextDisplayName: {}", displayName);
    }
}
