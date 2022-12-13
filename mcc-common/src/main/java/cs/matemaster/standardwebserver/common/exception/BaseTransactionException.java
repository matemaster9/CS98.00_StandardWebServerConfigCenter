package cs.matemaster.standardwebserver.common.exception;

import cs.matemaster.standardwebserver.common.constant.IErrorCode;
import lombok.Getter;

/**
 * @author matemaster
 */
@Getter
public class BaseTransactionException extends RuntimeException{
    private final IErrorCode errorCode;

    private final Object extraMessage;

    public BaseTransactionException(IErrorCode errorCode) {
        this.errorCode = errorCode;
        extraMessage = null;
    }

    public BaseTransactionException(IErrorCode errorCode, Object extraMessage) {
        this.errorCode = errorCode;
        this.extraMessage = extraMessage;
    }
}
