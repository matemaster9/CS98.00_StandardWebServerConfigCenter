import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;

import java.nio.charset.StandardCharsets;

/**
 * @author matemaster
 */
class SpringAmqpTests {

    @Test
    void messageBuilderApi() {

        MessageProperties properties = MessagePropertiesBuilder
                .newInstance()
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setMessageId("mcc")
                .setHeader("server", "mcc-tech-rabbitmq")
                .build();

        Message message1 = MessageBuilder
                .withBody("message".getBytes(StandardCharsets.UTF_8))
                .andProperties(properties)
                .build();

        Message message2 = MessageBuilder
                .withBody("message".getBytes(StandardCharsets.UTF_8))
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setMessageId("mcc")
                .setHeader("server", "mcc-tech-rabbitmq")
                .build();

        System.out.println(message1);
        System.out.println(message2);
    }
}
