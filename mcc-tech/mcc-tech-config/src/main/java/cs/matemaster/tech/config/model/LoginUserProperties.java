package cs.matemaster.tech.config.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

/**
 * @author matemaster
 */
@Getter
@ToString
@ConstructorBinding
@ConfigurationProperties(prefix = "login.user")
public class LoginUserProperties {
    private final String username;
    private final String password;
    private final List<String> inetAddressList;

    public LoginUserProperties(String username, String password, @DefaultValue List<String> inetAddressList) {
        this.username = username;
        this.password = password;
        this.inetAddressList = inetAddressList;
    }
}
