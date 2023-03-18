package cs.matemaster.rabbit_book.spring.event.custom;

import org.springframework.context.ApplicationEvent;

/**
 * @author matemaster
 */
public class WeatherRefreshEvent extends ApplicationEvent {

    public WeatherRefreshEvent(Object source) {
        super(source);
    }
}
