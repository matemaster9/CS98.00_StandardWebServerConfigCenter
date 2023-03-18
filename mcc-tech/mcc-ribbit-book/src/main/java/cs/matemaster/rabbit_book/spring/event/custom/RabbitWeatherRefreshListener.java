package cs.matemaster.rabbit_book.spring.event.custom;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
public class RabbitWeatherRefreshListener {

    @EventListener
    public void onApplicationEvent(WeatherRefreshEvent event) {

    }
}
