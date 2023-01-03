package cs.matemaster.tech.es;

import cs.matemaster.standardwebserver.infrastructure.es.ElasticSearchProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * @author matemaster
 */
@ConfigurationPropertiesScan(basePackageClasses = {ElasticSearchProps.class})
@SpringBootApplication(scanBasePackages = {
        "cs.matemaster.standardwebserver.infrastructure.es",
        "cs.matemaster.tech.es"
})
public class ElasticSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchApplication.class, args);
    }
}
