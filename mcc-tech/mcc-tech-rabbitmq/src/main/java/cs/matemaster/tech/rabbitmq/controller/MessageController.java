package cs.matemaster.tech.rabbitmq.controller;

import cs.matemaster.tech.rabbitmq.service.RabbitConsumeService;
import cs.matemaster.tech.rabbitmq.service.RabbitProduceService;
import cs.matemaster.tech.rabbitmq.service.impl.HelloWorldConsumeImpl;
import cs.matemaster.tech.rabbitmq.service.impl.HelloWorldProduceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@Slf4j
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final ApplicationContext applicationContext;

    @GetMapping("/hello-world-send")
    public void sendHelloWorld() {
        RabbitProduceService bean = applicationContext.getBean(HelloWorldProduceImpl.class);
        bean.sendMessage("RabbitMq: HelloWorld");
    }

    @GetMapping("/hello-world-get")
    public void getHelloWorld() {
        RabbitConsumeService bean = applicationContext.getBean(HelloWorldConsumeImpl.class);
        log.info(bean.getMessage());
    }
}
