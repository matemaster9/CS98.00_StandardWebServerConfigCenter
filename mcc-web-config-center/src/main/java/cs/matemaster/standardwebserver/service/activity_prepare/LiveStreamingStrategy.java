package cs.matemaster.standardwebserver.service.activity_prepare;

import cs.matemaster.standardwebserver.common.model.dto.activity_prepare.ActivityPreparePrincipalDto;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
public class LiveStreamingStrategy extends AbstractActivityPrepareStrategy implements ActivityPrepareService {
    @Override
    protected ActivityPreparePrincipalDto getPrincipal(String personalizedContent) {
        return null;
    }
}
