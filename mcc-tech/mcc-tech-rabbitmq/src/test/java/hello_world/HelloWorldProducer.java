package hello_world;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;

/**
 * @author matemaster
 */
public class HelloWorldProducer {

    @SneakyThrows
    public static void main(String[] args) {
        // todo：创建mq连接
        ConnectionFactory connectionFactory = new ConnectionFactory();

        // todo：设置mq连接工厂参数
        connectionFactory.setHost("10.37.129.102");
        connectionFactory.setUsername("mcc");
        connectionFactory.setPassword("matemaster98");
        connectionFactory.setPort(5672);

        String message = "RabbitMq: HelloWorld";
        try (Connection connection = connectionFactory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare("HELLO_WORLD", false, false, false, null);
            channel.basicPublish("", "HELLO_WORLD", null, message.getBytes(StandardCharsets.UTF_8));
        }
    }
}
