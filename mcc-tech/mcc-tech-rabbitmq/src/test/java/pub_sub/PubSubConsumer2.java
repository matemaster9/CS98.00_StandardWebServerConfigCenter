package pub_sub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * @author matemaster
 */
@Slf4j
public class PubSubConsumer2 {

    @SneakyThrows
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setUsername("mcc");
        connectionFactory.setPassword("matemaster98");
        connectionFactory.setPort(5672);
        connectionFactory.setHost("10.37.129.102");

        try (Connection connection = connectionFactory.newConnection(); Channel channel = connection.createChannel()) {
            DeliverCallback deliverCallback = (consumerTag, delivery) -> log.info(new String(delivery.getBody(), StandardCharsets.UTF_8));
            channel.basicConsume("pub_sub_fanout_q2", true, deliverCallback, consumerTag -> {
            });
        }
    }
}
