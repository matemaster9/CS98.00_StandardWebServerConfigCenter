package cs.matemaster.standardwebserver.app.controller;

import cs.matemaster.standardwebserver.app.facade.ActivityDataFunnelFacade;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@RestController
@RequestMapping("/activity-data-funnel")
@RequiredArgsConstructor
@Tag(name = "ActivityDataFunnelController", description = "活动数据漏斗控制器")
public class ActivityDataFunnelController {

    private final ActivityDataFunnelFacade activityDataFunnelFacade;

    @GetMapping("/export")
    public void export() {
        activityDataFunnelFacade.export();
    }

}
