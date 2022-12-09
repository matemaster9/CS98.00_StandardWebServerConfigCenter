package cs.matemaster.tech.config.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Collections;
import java.util.Map;

/**
 * @author matemaster
 */
@Getter
@ToString
@ConfigurationProperties(prefix = "app.system")
public class AppSystemProperties {
    private final Map<String, String> monthMap;
    private final Map<String, SystemUser> systemUsers;

    public AppSystemProperties() {
        monthMap = Collections.emptyMap();
        systemUsers = Collections.emptyMap();
    }

    @ConstructorBinding
    public AppSystemProperties(Map<String, String> monthMap, @DefaultValue Map<String, SystemUser> systemUsers) {
        this.monthMap = monthMap;
        this.systemUsers = systemUsers;
    }
}