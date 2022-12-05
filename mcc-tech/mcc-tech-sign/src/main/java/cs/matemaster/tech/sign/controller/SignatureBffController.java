package cs.matemaster.tech.sign.controller;

import cs.matemaster.tech.sign.aop.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@Auth
@Slf4j
@RestController
@RequestMapping("/sign-bff")
public class SignatureBffController {

    // 不加斜杠，匹配不到？ 为啥post mapping就行
    @GetMapping("/dashboard")
    public void dashboard() {
        log.info("访问首页!");
    }
}
