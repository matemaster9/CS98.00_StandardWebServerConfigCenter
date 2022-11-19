package cs.matemaster.standardwebserver.core;

import lombok.Data;

/**
 * @author matemaster
 */
@Data
public class BaseRuntimeException extends RuntimeException{

    private final BaseCode errorCode;

    private final Object extraMessage;


    public BaseRuntimeException() {
        super(ErrorCode.UNKNOWN.getMessage());
        errorCode = ErrorCode.UNKNOWN;
        extraMessage = null;
    }

    public BaseRuntimeException(BaseCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.extraMessage = null;
    }

    public BaseRuntimeException(BaseCode errorCode, Object extraMessage) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.extraMessage = extraMessage;
    }
}
