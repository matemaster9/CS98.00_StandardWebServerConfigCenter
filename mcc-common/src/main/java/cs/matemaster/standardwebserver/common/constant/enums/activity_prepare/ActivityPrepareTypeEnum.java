package cs.matemaster.standardwebserver.common.constant.enums.activity_prepare;

import cs.matemaster.standardwebserver.common.constant.IBizCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
@AllArgsConstructor
public enum ActivityPrepareTypeEnum implements IBizCode {

    LiveStreaming(1, "直播"),
    PrizeAward(2, "发奖/领奖"),
    OtherActivity(3, "其他活动");

    private final int code;
    private final String message;
    private static final Map<Integer, ActivityPrepareTypeEnum> ActivityPrepareTypeMap;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public static ActivityPrepareTypeEnum getInstanceByCode(int code) {
        return ActivityPrepareTypeMap.get(code);
    }

    static {
        ActivityPrepareTypeMap = Arrays
                .stream(ActivityPrepareTypeEnum.values())
                .collect(Collectors.toMap(ActivityPrepareTypeEnum::getCode, Function.identity()));
    }
}
