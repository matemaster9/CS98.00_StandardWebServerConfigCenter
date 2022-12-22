package cs.matemaster.standardwebserver.infrastructure.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties(prefix = "infrastructure.redis")
public class RedisClientProps {
    private boolean enable;
    private String host;
    private int port;
    private String password;
    private long maxWaitMills;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;
    private boolean testWhileIdle;
    private boolean blockWhenExhausted;
    private boolean info;
    private boolean jmxEnabled;
    private boolean fairness;
}
