package cs.matemaster.tech.rabbitmq.service.impl;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import cs.matemaster.tech.rabbitmq.service.RabbitProduceService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author matemaster
 */
@Service
public class HelloWorldProduceImpl implements RabbitProduceService {

    @SneakyThrows
    @Override
    public void sendMessage(String message) {

        // todo：创建mq连接
        ConnectionFactory connectionFactory = new ConnectionFactory();

        // todo：设置mq连接工厂参数
        connectionFactory.setHost("10.37.129.102");
        connectionFactory.setUsername("mcc");
        connectionFactory.setPassword("matemaster98");
        connectionFactory.setPort(5672);
        try (Connection connection = connectionFactory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare("QUEUE_NAME", false, false, false, null);
            channel.basicPublish("", "QUEUE_NAME", null, message.getBytes(StandardCharsets.UTF_8));
        }
    }
}
