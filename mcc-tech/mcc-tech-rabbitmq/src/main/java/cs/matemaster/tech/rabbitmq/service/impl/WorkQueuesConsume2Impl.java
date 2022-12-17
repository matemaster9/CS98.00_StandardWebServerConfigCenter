package cs.matemaster.tech.rabbitmq.service.impl;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import cs.matemaster.tech.rabbitmq.service.RabbitConsumeService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @author matemaster
 */
@Slf4j
@Service
public class WorkQueuesConsume2Impl implements RabbitConsumeService {

    @Override
    public String getMessage() {
        return null;
    }

    @SneakyThrows
    @Override
    public void consumeMessage() {
        // todo：创建mq连接
        ConnectionFactory connectionFactory = new ConnectionFactory();

        // todo：设置mq连接工厂参数
        connectionFactory.setHost("10.37.129.102");
        connectionFactory.setUsername("mcc");
        connectionFactory.setPassword("matemaster98");
        connectionFactory.setPort(5672);

        try (Connection connection = connectionFactory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare("WORK_QUEUES", false, false, false, null);
            DefaultConsumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("WorkQueuesConsume2Impl: " + new String(body, StandardCharsets.UTF_8));
                }
            };
            channel.basicConsume("WORK_QUEUES", true, consumer);
        }
    }
}
