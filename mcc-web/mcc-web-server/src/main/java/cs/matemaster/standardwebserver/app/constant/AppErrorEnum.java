package cs.matemaster.standardwebserver.app.constant;

import cs.matemaster.standardwebserver.common.constant.IErrorCode;
import lombok.AllArgsConstructor;

/**
 * @author matemaster
 */
@AllArgsConstructor
public enum AppErrorEnum implements IErrorCode {
    STORE_TABLE_SCHEMA_ERROR("ERRA001", "保存表模式信息失败"),
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
