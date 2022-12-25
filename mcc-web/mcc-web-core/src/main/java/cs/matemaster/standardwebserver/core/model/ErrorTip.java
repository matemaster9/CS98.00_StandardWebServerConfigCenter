package cs.matemaster.standardwebserver.core.model;

import cs.matemaster.standardwebserver.common.constant.ErrorEnum;
import cs.matemaster.standardwebserver.common.constant.IErrorCode;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
public class ErrorTip extends AbstractTip {

    private Object extraMessage;

    public ErrorTip() {
        this(ErrorEnum.UNKNOWN);
    }

    public ErrorTip(IErrorCode errorCode) {
        this(errorCode, null);
    }

    public ErrorTip(IErrorCode errorCode, Object extraMessage) {
        this(extraMessage, errorCode.getCode(), errorCode.getMessage());
    }

    public ErrorTip(Object extraMessage, String code, String message) {
        this.extraMessage = extraMessage;
        setCode(code);
        setMessage(message);
        setTimestamp(System.currentTimeMillis());
    }
}
