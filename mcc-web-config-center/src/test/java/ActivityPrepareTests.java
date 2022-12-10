import cs.matemaster.standardwebserver.WebConfigCenterApplication;
import cs.matemaster.standardwebserver.common.model.dto.activity_prepare.ActivityPrepareDto;
import cs.matemaster.standardwebserver.util.ActivityPrepareHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author matemaster
 */
@SpringBootTest(classes = WebConfigCenterApplication.class)
public class ActivityPrepareTests {

    @Autowired
    private ActivityPrepareHelper activityPrepareHelper;

    @Test
    public void helper() {
        List<String> auditors = activityPrepareHelper.getAuditors(new ActivityPrepareDto());
        List<String> wellKnownPeople = activityPrepareHelper.getWellKnownPeople(new ActivityPrepareDto());
    }
}
