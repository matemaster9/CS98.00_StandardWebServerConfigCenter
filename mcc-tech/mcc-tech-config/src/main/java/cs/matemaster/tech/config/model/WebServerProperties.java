package cs.matemaster.tech.config.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author matemaster
 */
@Setter
@Getter
@ToString
@Component
@ConfigurationProperties(prefix = "web.server")
public class WebServerProperties {
    private Map<String, String> application;
    private Map<String, List<String>> config;
    private Map<String, Credential> users;

    @Getter
    @Setter
    public static class Credential {
        private String username;
        private String password;
    }
}
