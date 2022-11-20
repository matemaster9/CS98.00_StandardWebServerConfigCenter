package cs.matemaster.standardwebserver.common.model.dto.sys;

import cs.matemaster.standardwebserver.common.exception.IllegalParamsException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

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

    public void validate() {
        if (StringUtils.isBlank(encryptAlgorithm)) {
            throw new IllegalParamsException("请输入加密算法");
        }

        if (StringUtils.isBlank(encryptedAccount)) {
            throw new IllegalParamsException("请输入账户");
        }

        if (StringUtils.isBlank(encryptedPassword)) {
            throw new IllegalParamsException("请输入密码");
        }
    }
}
