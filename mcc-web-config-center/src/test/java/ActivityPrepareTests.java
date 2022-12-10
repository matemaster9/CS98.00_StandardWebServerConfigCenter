import cs.matemaster.standardwebserver.WebConfigCenterApplication;
import cs.matemaster.standardwebserver.common.constant.enums.activity_prepare.ActivityPrepareTypeEnum;
import cs.matemaster.standardwebserver.common.model.dto.activity_prepare.ActivityPrepareDto;
import cs.matemaster.standardwebserver.common.model.dto.activity_prepare.ActivityPreparePrincipalDto;
import cs.matemaster.standardwebserver.config.ActivityPrepareConfig;
import cs.matemaster.standardwebserver.util.ActivityPrepareHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author matemaster
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebConfigCenterApplication.class)
public class ActivityPrepareTests {

    @Autowired
    private ActivityPrepareHelper activityPrepareHelper;

    @Autowired
    private ActivityPrepareConfig activityPrepareConfig;

    @Test
    public void helper() {
        List<String> auditors = activityPrepareHelper.getAuditors(new ActivityPrepareDto());
        List<String> wellKnownPeople = activityPrepareHelper.getWellKnownPeople(new ActivityPrepareDto());
    }

    @Test
    public void config() {
        Map<ActivityPrepareTypeEnum, ActivityPreparePrincipalDto> map = activityPrepareConfig.getActivityPreparePrincipalMap();
        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value.getDev());
        });
    }
}
