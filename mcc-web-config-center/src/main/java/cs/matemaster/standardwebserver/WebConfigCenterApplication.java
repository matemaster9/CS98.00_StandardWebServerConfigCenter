package cs.matemaster.standardwebserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author matemaster
 */
@MapperScan(basePackages = "cs.matemaster.standardwebserver.mapper")
@SpringBootApplication(scanBasePackages = {
        "cs.matemaster.standardwebserver",
        "cs.matemaster.standardwebserver.infrastructure.redis",
        "cs.matemaster.standardwebserver.authority",
        "cs.matemaster.standardwebserver.core"
})
public class WebConfigCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebConfigCenterApplication.class, args);
    }
}
