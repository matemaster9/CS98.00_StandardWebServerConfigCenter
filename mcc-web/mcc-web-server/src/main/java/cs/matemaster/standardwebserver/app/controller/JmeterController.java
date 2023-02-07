package cs.matemaster.standardwebserver.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@RestController
@RequestMapping("/jmeter")
public class JmeterController {

    @GetMapping("/get")
    public String getThreadName() {
        return Thread.currentThread().getName();
    }

}
