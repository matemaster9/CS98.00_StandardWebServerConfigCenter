package cs.matemaster.standardwebserver.service.activity_prepare;

import cs.matemaster.standardwebserver.common.model.dto.activity_prepare.ActivityPreparePrincipalDto;

/**
 * @author matemaster
 */
public class OtherActivityStrategy extends AbstractActivityPrepareStrategy implements ActivityPrepareService {
    @Override
    protected ActivityPreparePrincipalDto getPrincipal(String personalizedContent) {
        return null;
    }
}
