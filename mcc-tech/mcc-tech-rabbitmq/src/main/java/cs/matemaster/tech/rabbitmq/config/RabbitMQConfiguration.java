package cs.matemaster.tech.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author matemaster
 */
@Configuration
@EnableConfigurationProperties(value = RabbitMqProps.class)
public class RabbitMQConfiguration {

    @Bean
    public FanoutExchange activityFanoutExchange() {
        return new FanoutExchange("pub_sub_fanout");
    }

    @Bean
    public Queue fanoutQueue() {
        return new Queue("pub_sub_fanout_q1");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(fanoutQueue())
                .to(activityFanoutExchange());
    }
}
