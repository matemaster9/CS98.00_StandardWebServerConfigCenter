package cs.matemaster.standardwebserver.authority.exception;

import cs.matemaster.standardwebserver.core.BaseCode;
import cs.matemaster.standardwebserver.core.ErrorCode;

/**
 * @author matemaster
 */
public class AuthException extends RuntimeException{
    private BaseCode errorCode;

    private Object extraMessage;


    public AuthException() {
        super(ErrorCode.UNKNOWN.getMessage());
        errorCode = ErrorCode.UNKNOWN;
    }

    public AuthException(BaseCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.extraMessage = null;
    }

    public AuthException(BaseCode errorCode, Object extraMessage) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.extraMessage = extraMessage;
    }
}
