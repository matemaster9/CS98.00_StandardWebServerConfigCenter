package cs.matemaster.tech.rabbitmq.util;

import com.rabbitmq.client.ConnectionFactory;

/**
 * @author matemaster
 */
public final class RabbitMqUtil {

    private RabbitMqUtil() {
        throw new UnsupportedOperationException();
    }

    public static ConnectionFactory getConnectionFactory() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("10.37.129.102");
        connectionFactory.setUsername("mcc");
        connectionFactory.setPassword("matemaster98");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }
}
