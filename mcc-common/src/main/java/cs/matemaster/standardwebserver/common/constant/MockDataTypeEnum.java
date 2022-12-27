package cs.matemaster.standardwebserver.common.constant;

import lombok.AllArgsConstructor;

/**
 * @author matemaster
 */
@AllArgsConstructor
public enum MockDataTypeEnum {
    City(1,"城市"),
    ;

    private final int code;

    private final String message;

    public static MockDataTypeEnum getInstanceByCode(Integer mockType) {
        return null;
    }
}
