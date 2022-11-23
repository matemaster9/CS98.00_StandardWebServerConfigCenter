package cs.matemaster.standardwebserver.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@Slf4j
@RestController
@RequestMapping("/mock")
@AllArgsConstructor
@Tag(name = "MockController", description = "模拟控制器")
public class MockController {

    public void exportInterfaceAnalytics() {

    }
}
