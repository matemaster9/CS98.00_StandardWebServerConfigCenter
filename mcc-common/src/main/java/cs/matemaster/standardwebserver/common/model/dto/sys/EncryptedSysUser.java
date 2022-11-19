package cs.matemaster.standardwebserver.common.model.dto.sys;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
@Schema(name = "EncryptedSysUser", description = "加密用户")
public class EncryptedSysUser {

    @Schema(description = "加密算法")
    private String encryptAlgorithm;

    @Schema(description = "账户秘文")
    private String encryptedAccount;

    @Schema(description = "密码秘文")
    private String encryptedPassword;
}
