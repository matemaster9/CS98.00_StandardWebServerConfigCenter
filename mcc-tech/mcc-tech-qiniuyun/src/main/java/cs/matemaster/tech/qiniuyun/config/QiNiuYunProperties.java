package cs.matemaster.tech.qiniuyun.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "qi-niu-yun")
public class QiNiuYunProperties {
    private String accessKey;
    private String secretKey;
    private String bucket;
}
