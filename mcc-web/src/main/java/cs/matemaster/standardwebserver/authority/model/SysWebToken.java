package cs.matemaster.standardwebserver.authority.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
@AllArgsConstructor
public class SysWebToken {
    private String accessToken;
    private String refreshToken;
}
