package cs.matemaster.standardwebserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties(prefix = SecurityConfig.SECURITY_PREFIX)
public class SecurityConfig {
    public static final String SECURITY_PREFIX = "security";

    private String aesSecretKey;

    private String rsaPublicKey;

    private String rsaPrivateKey;
}
