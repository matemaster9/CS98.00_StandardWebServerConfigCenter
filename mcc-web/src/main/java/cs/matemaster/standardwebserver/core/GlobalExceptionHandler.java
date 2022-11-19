package cs.matemaster.standardwebserver.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author matemaster
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseRuntimeException.class)
    public ErrorTip getBaseRuntimeException(BaseRuntimeException err) {
        BaseCode errorCode = err.getErrorCode();
        return new ErrorTip(err.getExtraMessage(), errorCode.getCode(), errorCode.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ErrorTip getException(Exception err) {
        log.error(err.getMessage());
        return new ErrorTip();
    }
}
