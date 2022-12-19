package cs.matemaster.tech.rabbitmq.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * @author matemaster
 */
@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = RabbitMqConfig.RABBIT_PREFIX)
public class RabbitMqConfig {

    public static final String RABBIT_PREFIX = "infrastructure.rabbit-mq";


}
