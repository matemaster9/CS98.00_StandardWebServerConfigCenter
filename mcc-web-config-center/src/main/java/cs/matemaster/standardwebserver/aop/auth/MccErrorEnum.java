package cs.matemaster.standardwebserver.aop.auth;

import cs.matemaster.standardwebserver.core.BaseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author matemaster
 */
@Getter
@AllArgsConstructor
public enum MccErrorEnum implements BaseCode {
    MCC_TOKEN_EXPIRE("MCA0001", "token已过期"),
    MCC_CLAIMS_NOT_MATCH("MCA0002", "claims不匹配"),
    MCC_TOKEN_INVALID("MCA0003", "无效token");

    private final String code;
    private final String message;

}
