package cs.matemaster.standardwebserver.common.exception;

import cs.matemaster.standardwebserver.common.constant.ErrorEnum;
import cs.matemaster.standardwebserver.common.constant.IErrorCode;
import lombok.Getter;

/**
 * @author matemaster
 */
@Getter
public class IllegalParamsException extends RuntimeException {

    private final IErrorCode errorCode;

    private final String extraMessage;

    public IllegalParamsException() {
        super(ErrorEnum.ILLEGAL_PARAMETER.getMessage());
        errorCode = ErrorEnum.ILLEGAL_PARAMETER;
        extraMessage = null;
    }

    public IllegalParamsException(IErrorCode errorCode) {
        this.errorCode = errorCode;
        this.extraMessage = "";
    }

    public IllegalParamsException(IErrorCode errorCode, String extraMessage) {
        this.errorCode = errorCode;
        this.extraMessage = extraMessage;
    }

    public IllegalParamsException(String extraMessage) {
        super(ErrorEnum.ILLEGAL_PARAMETER.getMessage());
        this.errorCode = ErrorEnum.ILLEGAL_PARAMETER;
        this.extraMessage = extraMessage;
    }
}
