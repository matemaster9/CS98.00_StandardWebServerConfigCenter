package hello_world;

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
public class HelloWorldConsumer {

    @SneakyThrows
    public static void main(String[] args) {
        // todo：创建mq连接
        ConnectionFactory connectionFactory = new ConnectionFactory();

        // todo：设置mq连接工厂参数
        connectionFactory.setHost("10.37.129.102");
        connectionFactory.setUsername("mcc");
        connectionFactory.setPassword("matemaster98");
        connectionFactory.setPort(5672);

        try (Connection connection = connectionFactory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare("HELLO_WORLD", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> log.info(new String(delivery.getBody(), StandardCharsets.UTF_8));
            channel.basicConsume("HELLO_WORLD", true, deliverCallback, consumerTag -> {
            });
        }
    }
}
