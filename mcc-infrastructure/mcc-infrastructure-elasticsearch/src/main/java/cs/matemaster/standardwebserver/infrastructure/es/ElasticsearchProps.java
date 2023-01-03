package cs.matemaster.standardwebserver.infrastructure.es;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * @author matemaster
 */
@Getter
@ConfigurationProperties(prefix = "infrastructure.elasticsearch")
public class ElasticsearchProps {

    private final Boolean enable;

    /**
     * es 用户
     */
    private final String username;

    /**
     * es 密码
     */
    private final String password;

    /**
     * es 端口
     */
    private final Integer port;

    /**
     * es 服务器地址
     */
    private final String address;

    /**
     * es 连接协议
     */
    private final String scheme;

    @ConstructorBinding
    public ElasticsearchProps(Boolean enable, String username, String password, Integer port, String address, String scheme) {
        this.enable = enable;
        this.username = username;
        this.password = password;
        this.port = port;
        this.address = address;
        this.scheme = scheme;
    }
}
