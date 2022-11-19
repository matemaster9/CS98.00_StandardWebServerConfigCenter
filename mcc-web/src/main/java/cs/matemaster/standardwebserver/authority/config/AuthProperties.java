package cs.matemaster.standardwebserver.authority.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties(prefix = "auth")
public class AuthProperties {
    private String rsaPublicKey;
    private String rsaPrivateKey;
}
