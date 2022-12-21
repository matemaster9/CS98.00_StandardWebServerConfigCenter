import cs.matemaster.standardwebserver.common.util.JsonUtil;
import cs.matemaster.tech.rabbitmq.RabbitMqIntegratedApplication;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;


/**
 * @author matemaster
 */
@SpringBootTest(classes = RabbitMqIntegratedApplication.class)
class RabbitMqIntegratedApplicationTests {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void instance() {
        System.out.println(connectionFactory);
        System.out.println(connectionFactory.getClass().getName());
    }

    @Test
    void sendMessage() {
        Message message = MessageBuilder
                .withBody("message".getBytes(StandardCharsets.UTF_8))
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setMessageId("mcc")
                .setHeader("server", "mcc-tech-rabbitmq")
                .build();

        String exchange = "";
        String routingKey = "";

        rabbitTemplate.send(exchange, routingKey, message);
    }

    @Test
    void sendMessage_v1() {
        Message message = MessageBuilder
                .withBody("message".getBytes(StandardCharsets.UTF_8))
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setMessageId("mcc")
                .setHeader("server", "mcc-tech-rabbitmq")
                .build();

        String exchange = "";
        String routingKey = "";
        rabbitTemplate.setExchange(exchange);
        rabbitTemplate.setRoutingKey(routingKey);
        rabbitTemplate.send(message);
    }

    @Test
    void publisherReturns() {
        ConnectionFactory connectionFactory1 = rabbitTemplate.getConnectionFactory();
        boolean publisherReturns = connectionFactory1.isPublisherReturns();
        System.out.println(publisherReturns);
    }
}
