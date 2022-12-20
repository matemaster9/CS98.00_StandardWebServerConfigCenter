import cs.matemaster.tech.rabbitmq.RabbitMqIntegratedApplication;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author matemaster
 */
@SpringBootTest(classes = RabbitMqIntegratedApplication.class)
class RabbitMqIntegratedApplicationTests {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Test
    void instance() {
        System.out.println(connectionFactory);
        System.out.println(connectionFactory.getClass().getName());
    }
}
