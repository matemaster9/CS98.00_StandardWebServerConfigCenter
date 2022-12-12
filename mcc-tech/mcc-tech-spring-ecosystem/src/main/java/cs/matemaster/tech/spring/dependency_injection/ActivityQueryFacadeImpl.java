package cs.matemaster.tech.spring.dependency_injection;

import cs.matemaster.tech.spring.service.ActivityQueryService;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
public class ActivityQueryFacadeImpl {

    private final ActivityQueryService service;

    public ActivityQueryFacadeImpl(ActivityQueryService service) {
        this.service = service;
    }

    public void stdOut() {
        System.out.println(service.getActivities());
    }
}
