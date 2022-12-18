package topics;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import cs.matemaster.tech.rabbitmq.util.RabbitMqUtil;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;

/**
 * @author matemaster
 */
public class TopicProducer {

    @SneakyThrows
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = RabbitMqUtil.getConnectionFactory();

        String message = "RabbitMq: Topic";
        String topicExchange = "log_topic";
        try (Connection connection = connectionFactory.newConnection(); Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(topicExchange, BuiltinExchangeType.TOPIC, false);
            channel.basicPublish(topicExchange, "error.#", null, message.getBytes(StandardCharsets.UTF_8));
        }
    }
}
