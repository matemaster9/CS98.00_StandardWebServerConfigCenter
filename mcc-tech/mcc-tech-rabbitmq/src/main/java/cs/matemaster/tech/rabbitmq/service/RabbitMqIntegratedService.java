package cs.matemaster.tech.rabbitmq.service;

/**
 * @author matemaster
 */
public interface RabbitMqIntegratedService {

    void sendMessage(String msg);

    void consume();
}
