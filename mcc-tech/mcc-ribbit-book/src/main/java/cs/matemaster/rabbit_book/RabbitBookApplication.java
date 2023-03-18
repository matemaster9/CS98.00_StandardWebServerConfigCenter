package cs.matemaster.rabbit_book;

import cs.matemaster.rabbit_book.spring.aware.RabbitContextAwareComponent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author matemaster
 */
@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class RabbitBookApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RabbitBookApplication.class);
        checkRabbiContextAwareComponent(run);
    }

    static void checkRabbiContextAwareComponent(ConfigurableApplicationContext configurableApplicationContext) {
        RabbitContextAwareComponent component = configurableApplicationContext.getBean(RabbitContextAwareComponent.class);
        component.printContextDisplayNameToConsole();
    }
}
