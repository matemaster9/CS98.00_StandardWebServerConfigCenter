package cs.matemaster.standardwebserver.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
@Getter
@AllArgsConstructor
public enum MockDataTypeEnum {
    City(1, "城市"),
    ChineseName(2, "中文名"),
    EnglishName(3, "英文名"),
    Job(4, "职业"),
    ;

    private final int code;

    private final String message;

    private static final Map<Integer, MockDataTypeEnum> ENUM_MAP = Arrays.stream(MockDataTypeEnum.values()).collect(Collectors.toMap(MockDataTypeEnum::getCode, t -> t));


    public static MockDataTypeEnum getInstanceByCode(Integer mockType) {
        return ENUM_MAP.get(mockType);
    }
}
