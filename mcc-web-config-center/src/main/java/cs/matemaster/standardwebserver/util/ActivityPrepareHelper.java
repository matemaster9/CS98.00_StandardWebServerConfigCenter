package cs.matemaster.standardwebserver.util;

import com.google.common.collect.ImmutableMap;
import cs.matemaster.standardwebserver.common.constant.enums.activity_prepare.ActivityPrepareTypeEnum;
import cs.matemaster.standardwebserver.common.exception.IllegalParamsException;
import cs.matemaster.standardwebserver.common.model.dto.activity_prepare.ActivityPrepareDto;
import cs.matemaster.standardwebserver.service.activity_prepare.ActivityPrepareService;
import cs.matemaster.standardwebserver.service.activity_prepare.LiveStreamingStrategy;
import cs.matemaster.standardwebserver.service.activity_prepare.OtherActivityStrategy;
import cs.matemaster.standardwebserver.service.activity_prepare.PrizeAwardStrategy;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @author matemaster
 */
@Component
@RequiredArgsConstructor
public class ActivityPrepareHelper {

    private final ApplicationContext applicationContext;
    private Map<ActivityPrepareTypeEnum, ActivityPrepareService> activityPrepareServiceMap;

    @PostConstruct
    public void initActivityPrepareServiceMap() {
        activityPrepareServiceMap = ImmutableMap.<ActivityPrepareTypeEnum, ActivityPrepareService>builder()
                .put(ActivityPrepareTypeEnum.LiveStreaming, applicationContext.getBean(LiveStreamingStrategy.class))
                .put(ActivityPrepareTypeEnum.PrizeAward, applicationContext.getBean(PrizeAwardStrategy.class))
                .put(ActivityPrepareTypeEnum.OtherActivity, applicationContext.getBean(OtherActivityStrategy.class))
                .build();
    }

    public List<String> getAuditors(ActivityPrepareDto activityPrepare) {
        ActivityPrepareTypeEnum activityPrepareTypeEnum = ActivityPrepareTypeEnum.getInstanceByCode(activityPrepare.getActivityPrepareType());
        if (activityPrepareTypeEnum == null) {
            throw new IllegalParamsException("活动报备类型不存在");
        }
        ActivityPrepareService activityPrepareService = activityPrepareServiceMap.get(activityPrepareTypeEnum);
        return activityPrepareService.getAuditors(activityPrepare.getPersonalizedContent());
    }

    public List<String> getWellKnownPeople(ActivityPrepareDto activityPrepare) {
        ActivityPrepareTypeEnum activityPrepareTypeEnum = ActivityPrepareTypeEnum.getInstanceByCode(activityPrepare.getActivityPrepareType());
        if (activityPrepareTypeEnum == null) {
            throw new IllegalParamsException("活动报备类型不存在");
        }
        ActivityPrepareService activityPrepareService = activityPrepareServiceMap.get(activityPrepareTypeEnum);
        return activityPrepareService.getWellKnownPeople(activityPrepare.getPersonalizedContent());
    }
}
