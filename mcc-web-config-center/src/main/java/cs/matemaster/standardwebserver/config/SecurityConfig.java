package cs.matemaster.standardwebserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties(prefix = "security")
public class SecurityConfig {

    private String aesSecretKey;

    private String rsaPublicKey;

    private String rsaPrivateKey;
}
