package cs.matemaster.standardwebserver.service.activity_prepare;

import cs.matemaster.standardwebserver.common.model.dto.activity_prepare.ActivityPreparePrincipalDto;

import java.util.List;

/**
 * @author matemaster
 */
public abstract class AbstractActivityPrepareStrategy implements ActivityPrepareService {


    @Override
    public List<String> getAuditors(String personalizedContent) {
        ActivityPreparePrincipalDto principal = getPrincipal(personalizedContent);
        return null;
    }

    @Override
    public List<String> getWellKnownPeople(String personalizedContent) {
        return null;
    }

    protected abstract ActivityPreparePrincipalDto getPrincipal(String personalizedContent);
}
