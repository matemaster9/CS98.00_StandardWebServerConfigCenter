package cs.matemaster.tech.rabbitmq.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author matemaster
 */
@Configuration
@EnableConfigurationProperties(value = RabbitMqConfig.class)
public class RabbitMQConfiguration {
}
