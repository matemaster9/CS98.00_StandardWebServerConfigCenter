package cs.matemaster.tech.sign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author matemaster
 */
@Slf4j
@SpringBootApplication
public class SignApplication {
    public static void main(String[] args) {
        SpringApplication.run(SignApplication.class, args);
    }

    @PostConstruct
    public void start() {
        log.info("SignApplication应用启动");
    }

    @PreDestroy
    public void destroy() {
        log.info("SignApplication应用关闭");
    }
}
