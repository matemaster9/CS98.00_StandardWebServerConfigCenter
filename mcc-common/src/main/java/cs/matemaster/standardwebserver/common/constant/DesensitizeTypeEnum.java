package cs.matemaster.standardwebserver.common.constant;

import lombok.AllArgsConstructor;

/**
 * @author matemaster
 */
@AllArgsConstructor
public enum DesensitizeTypeEnum {

    Mobile(1, "");

    private final int code;
    private final String pattern;
}
