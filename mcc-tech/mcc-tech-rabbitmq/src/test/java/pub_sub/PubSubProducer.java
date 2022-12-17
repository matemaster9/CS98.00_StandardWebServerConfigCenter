package pub_sub;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author matemaster
 */
public class PubSubProducer {

    @SneakyThrows
    public static void main(String[] args) {
        // todo：创建mq连接
        ConnectionFactory connectionFactory = new ConnectionFactory();

        // todo：设置mq连接工厂参数
        connectionFactory.setHost("10.37.129.102");
        connectionFactory.setUsername("mcc");
        connectionFactory.setPassword("matemaster98");
        connectionFactory.setPort(5672);

        String message = "RabbitMq: PubSub";
        String fanoutExchange = "pub_sub_fanout";
        String queue1 = "pub_sub_fanout_q1";
        String queue2 = "pub_sub_fanout_q2";
        try (Connection connection = connectionFactory.newConnection(); Channel channel = connection.createChannel()) {
            // todo: 创建交换机
            channel.exchangeDeclare(fanoutExchange, BuiltinExchangeType.FANOUT, true, false, false, null);
            // todo：声明队列
            channel.queueDeclare(queue1, true, false, false, null);
            channel.queueDeclare(queue2, true, false, false, null);
            // todo：绑定队列交换机
            channel.queueBind(queue1, fanoutExchange, "");
            channel.queueBind(queue2, fanoutExchange, "");

            // todo：发消息
            channel.basicPublish(fanoutExchange, "", null, message.getBytes(StandardCharsets.UTF_8));
        }
    }
}
