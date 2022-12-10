package cs.matemaster.standardwebserver.config;

import cs.matemaster.standardwebserver.common.constant.enums.activity_prepare.ActivityPrepareTypeEnum;
import cs.matemaster.standardwebserver.common.model.dto.activity_prepare.ActivityPreparePrincipalDto;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Map;

/**
 * @author matemaster
 */
@Getter
@ConfigurationProperties(prefix = "activity-prepare")
public class ActivityPrepareConfig {

    private final Map<ActivityPrepareTypeEnum, ActivityPreparePrincipalDto> activityPreparePrincipalMap;

    @ConstructorBinding
    public ActivityPrepareConfig(Map<ActivityPrepareTypeEnum, ActivityPreparePrincipalDto> activityPreparePrincipalMap) {
        this.activityPreparePrincipalMap = activityPreparePrincipalMap;
    }
}
