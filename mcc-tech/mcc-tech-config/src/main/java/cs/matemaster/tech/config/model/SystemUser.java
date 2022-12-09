package cs.matemaster.tech.config.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author matemaster
 */
@Setter
@Getter
@ToString
public class SystemUser {
    private String username;
    private String password;
}