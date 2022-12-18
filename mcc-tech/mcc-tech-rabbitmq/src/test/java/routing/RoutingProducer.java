package routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;

/**
 * @author matemaster
 */
public class RoutingProducer {

    @SneakyThrows
    public static void main(String[] args) {
        // todo: 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();

        // todo: 补充rabbit服务器参数
        connectionFactory.setHost("10.37.129.102");
        connectionFactory.setUsername("mcc");
        connectionFactory.setPassword("matemaster98");
        connectionFactory.setPort(5672);

        // todo：交换机与队列名称
        String message = "RabbitMq: Routing";
        String directExchange = "log_routing";
        String errorLogQueue = "error_queue";
        String infoLogQueue = "info_queue";
        String warnLogQueue = "warn_queue";
        try (Connection connection = connectionFactory.newConnection(); Channel channel = connection.createChannel()) {
            // todo：声明交换机
            channel.exchangeDeclare(directExchange, BuiltinExchangeType.DIRECT, false);

            // todo：声明队列
            channel.queueDeclare(errorLogQueue, false, false, false, null);
            channel.queueDeclare(infoLogQueue, false, false, false, null);
            channel.queueDeclare(warnLogQueue, false, false, false, null);

            // todo：设置交换机与队列的绑定关系
            channel.queueBind(errorLogQueue, directExchange, "error");
            channel.queueBind(infoLogQueue, directExchange, "info");
            channel.queueBind(warnLogQueue, directExchange, "warn");

            // todo：利用指定routing-key想交换机发送消息
            channel.basicPublish(directExchange, "error", null, message.getBytes(StandardCharsets.UTF_8));
            channel.basicPublish(directExchange, "info", null, message.getBytes(StandardCharsets.UTF_8));
            channel.basicPublish(directExchange, "warn", null, message.getBytes(StandardCharsets.UTF_8));
        }
    }
}
