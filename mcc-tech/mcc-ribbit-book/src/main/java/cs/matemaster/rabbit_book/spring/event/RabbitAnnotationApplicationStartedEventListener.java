package cs.matemaster.rabbit_book.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 注解@EventListener监听指定事件：ApplicationStartedEvent
 * @author matemaster
 */
@Slf4j
@Component
public class RabbitAnnotationApplicationStartedEventListener {

    @EventListener
    public void contextStarted(ApplicationStartedEvent startedEvent) {
        long timestamp = startedEvent.getTimestamp();
        log.info("RabbitAnnotationContextStoppedEventListener: context started at {}", timestamp);
    }
}
