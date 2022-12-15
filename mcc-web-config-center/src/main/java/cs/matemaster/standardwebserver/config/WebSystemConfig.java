package cs.matemaster.standardwebserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties(prefix = WebSystemConfig.WBE_SYSTEM_PREFIX)
public class WebSystemConfig {
    public static final String WBE_SYSTEM_PREFIX = "system";
    private String rsaPublicKey;
    private String rsaPrivateKey;
}
