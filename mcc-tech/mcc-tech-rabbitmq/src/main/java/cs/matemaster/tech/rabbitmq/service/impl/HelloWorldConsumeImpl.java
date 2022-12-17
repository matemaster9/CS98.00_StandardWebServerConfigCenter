package cs.matemaster.tech.rabbitmq.service.impl;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import cs.matemaster.tech.rabbitmq.service.RabbitConsumeService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author matemaster
 */
@Service
public class HelloWorldConsumeImpl implements RabbitConsumeService {

    @SneakyThrows
    @Override
    public String getMessage() {

        // todo：创建mq连接
        ConnectionFactory connectionFactory = new ConnectionFactory();

        // todo：设置mq连接工厂参数
        connectionFactory.setHost("10.37.129.102");
        connectionFactory.setUsername("mcc");
        connectionFactory.setPassword("matemaster98");
        connectionFactory.setPort(5672);

        final String[] message = new String[1];
        try (Connection connection = connectionFactory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare("HELLO_WORLD", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                message[0] = new String(delivery.getBody(), StandardCharsets.UTF_8);
            };
            channel.basicConsume("HELLO_WORLD", true, deliverCallback, consumerTag -> {
            });
        }
        return message[0];
    }
}
