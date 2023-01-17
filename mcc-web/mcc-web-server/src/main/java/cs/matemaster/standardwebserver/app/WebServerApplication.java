package cs.matemaster.standardwebserver.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author matemaster
 */
@MapperScan(basePackages = "cs.matemaster.standardwebserver.app.persistence")
@SpringBootApplication
public class WebServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebServerApplication.class, args);
    }
}
