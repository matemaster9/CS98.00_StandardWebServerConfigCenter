package cs.matemaster.standardwebserver.authority.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
@AllArgsConstructor
@Schema(description = "系统token")
public class SysWebToken {

    @Schema(description = "客户端token")
    private String accessToken;

    @Schema(description = "服务端token")
    private String refreshToken;
}
