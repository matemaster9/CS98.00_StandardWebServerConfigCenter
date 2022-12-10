package cs.matemaster.standardwebserver.service.activity_prepare;

import java.util.List;

/**
 * @author matemaster
 */
public interface ActivityPrepareService {

    List<String> getAuditors(String personalizedContent);

    List<String> getWellKnownPeople(String personalizedContent);
}
