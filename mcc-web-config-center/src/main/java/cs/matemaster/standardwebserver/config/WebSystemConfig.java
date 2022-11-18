package cs.matemaster.standardwebserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties(prefix = "system")
public class WebSystemConfig {
    private String rsaPublicKey;
    private String rsaPrivateKey;
}
