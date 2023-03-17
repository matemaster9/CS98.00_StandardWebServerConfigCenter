package cs.matemaster.rabbit_book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author matemaster
 */
@Slf4j
@SpringBootApplication
public class RabbitBookApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RabbitBookApplication.class);
    }
}
