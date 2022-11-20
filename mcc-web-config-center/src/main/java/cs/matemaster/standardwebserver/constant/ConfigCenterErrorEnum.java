package cs.matemaster.standardwebserver.constant;

import cs.matemaster.standardwebserver.common.constant.IErrorCode;
import lombok.AllArgsConstructor;

/**
 * @author matemaster
 */
@AllArgsConstructor
public enum ConfigCenterErrorEnum implements IErrorCode {
    MCCA_ACCOUNT_NOT_EXIST("MCCA0001","账户不存在"),
    MCCA_PASSWORD_ERROR("MCCA0002","账户密码错误"),
    ;

    private final String code;

    private final String message;


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
