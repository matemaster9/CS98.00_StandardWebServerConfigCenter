package cs.matemaster.standardwebserver.common.exception;

import cs.matemaster.standardwebserver.common.constant.ErrorEnum;
import cs.matemaster.standardwebserver.common.constant.IErrorCode;

/**
 * @author matemaster
 */
public class IllegalParamsException extends RuntimeException {

    private final IErrorCode errorCode;

    private final Object extraMessage;

    public IllegalParamsException() {
        super(ErrorEnum.ILLEGAL_PARAMETER.getMessage());
        errorCode = ErrorEnum.ILLEGAL_PARAMETER;
        extraMessage = null;
    }

    public IllegalParamsException(IErrorCode errorCode, Object extraMessage) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.extraMessage = extraMessage;
    }
}
