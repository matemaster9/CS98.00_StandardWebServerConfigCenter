package cs.matemaster.tech.config.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@RestController
@AllArgsConstructor
@RequestMapping("/env")
public class EnvController {

    private Environment environment;

    @GetMapping("/get")
    public void get() {
        StandardEnvironment standardEnvironment = (StandardEnvironment) environment;
    }
}
