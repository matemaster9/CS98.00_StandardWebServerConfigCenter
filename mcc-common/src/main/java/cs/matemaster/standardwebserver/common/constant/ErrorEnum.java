package cs.matemaster.standardwebserver.common.constant;

import lombok.AllArgsConstructor;

/**
 * @author matemaster
 */
@AllArgsConstructor
public enum ErrorEnum implements IErrorCode {

    SUCCESS("SUC0000", "成功"),
    UNKNOWN("ERR0000", "未知错误"),
    ILLEGAL_PARAMETER("ERR0001", "非法参数"),
    TECH_ERROR("ERROOO2", "mcc-tech错误")
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
