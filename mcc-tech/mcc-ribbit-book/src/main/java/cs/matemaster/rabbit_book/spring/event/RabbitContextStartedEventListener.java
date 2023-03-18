package cs.matemaster.rabbit_book.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * implements ApplicationListener<?> 实现接口优先于注解 @EventListener
 * @author matemaster
 */
@Slf4j
@Component
public class RabbitContextStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        log.info("RabbitContextStartedEventListener: {}", "context started!");
    }
}
