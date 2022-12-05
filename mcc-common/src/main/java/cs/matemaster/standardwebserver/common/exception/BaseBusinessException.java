package cs.matemaster.standardwebserver.common.exception;

import cs.matemaster.standardwebserver.common.constant.ErrorEnum;
import cs.matemaster.standardwebserver.common.constant.IErrorCode;
import lombok.Getter;

/**
 * @author matemaster
 */
@Getter
public class BaseBusinessException extends RuntimeException{

    private final IErrorCode errorCode;

    private final Object extraMessage;

    public BaseBusinessException(IErrorCode errorCode) {
        this.errorCode = errorCode;
        extraMessage = null;
    }

    public BaseBusinessException(IErrorCode errorCode, Object extraMessage) {
        this.errorCode = errorCode;
        this.extraMessage = extraMessage;
    }

    public BaseBusinessException(String errorMessage) {
        errorCode = ErrorEnum.TECH_ERROR;
        extraMessage = errorMessage;
    }
}
