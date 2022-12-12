package cs.matemaster.tech.spring.service.impl;

import cs.matemaster.tech.spring.service.ActivityQueryService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author matemaster
 */
@Service
public class ActivityQueryServiceImpl implements ActivityQueryService {
    @Override
    public List<String> getActivities() {
        return Collections.singletonList("activities");
    }
}
