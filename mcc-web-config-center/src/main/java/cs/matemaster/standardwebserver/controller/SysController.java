package cs.matemaster.standardwebserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@Slf4j
@RestController
@RequestMapping("/system")
@Tag(name = "SysController", description = "系统控制器")
public class SysController {

    @Operation(summary = "welcome")
    @GetMapping("welcome")
    public void welcome() {
        log.info("进入系统");
    }


}
