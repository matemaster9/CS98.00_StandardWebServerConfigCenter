package cs.matemaster.standardwebserver.core.config;

import cs.matemaster.standardwebserver.common.exception.BaseBusinessException;
import cs.matemaster.standardwebserver.common.exception.BaseTransactionException;
import cs.matemaster.standardwebserver.common.exception.IllegalParamsException;
import cs.matemaster.standardwebserver.core.model.ErrorTip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author matemaster
 */
@Slf4j
@ResponseBody
@ControllerAdvice
@ConditionalOnProperty(value = "web-core.global-enable", havingValue = "true")
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseBusinessException.class)
    public ErrorTip baseBusinessException(BaseBusinessException exception) {
        return new ErrorTip(exception.getErrorCode(), exception.getExtraMessage());
    }

    @ExceptionHandler(BaseTransactionException.class)
    public ErrorTip baseTransactionException(BaseTransactionException exception) {
        return new ErrorTip(exception.getErrorCode(), exception.getExtraMessage());
    }

    @ExceptionHandler(IllegalParamsException.class)
    public ErrorTip illegalParamsException(IllegalParamsException exception) {
        return new ErrorTip(exception.getErrorCode(), exception.getExtraMessage());
    }

    @ExceptionHandler(Exception.class)
    public ErrorTip unknown(Exception ex) {
        return new ErrorTip();
    }
}
