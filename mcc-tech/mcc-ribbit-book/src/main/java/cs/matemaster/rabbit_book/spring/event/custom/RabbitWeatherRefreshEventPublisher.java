package cs.matemaster.rabbit_book.spring.event.custom;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
@RequiredArgsConstructor
public class RabbitWeatherRefreshEventPublisher {

    private final ApplicationEventPublisher publisher;

    public void publish(WeatherRefreshEvent event) {
        publisher.publishEvent(event);
    }
}
