package cs.matemaster.standardwebserver.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
@Schema(name = "SysUserDto", description = "系统用户")
public class SysUserDto {

    @Schema(description = "账号")
    private String account;

    @Schema(description = "密码")
    private String password;
}
