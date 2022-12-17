package cs.matemaster.tech.rabbitmq.service;

/**
 * @author matemaster
 */
public interface RabbitProduceService {

    void sendMessage(String message);
}
