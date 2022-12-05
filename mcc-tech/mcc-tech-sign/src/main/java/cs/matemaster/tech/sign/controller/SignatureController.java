package cs.matemaster.tech.sign.controller;

import cs.matemaster.tech.sign.aop.Auth;
import cs.matemaster.tech.sign.facade.SignatureFacade;
import cs.matemaster.tech.sign.model.SysUserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/sign")
public class SignatureController {

    private SignatureFacade signatureFacade;

    @PostMapping("getToken")
    public String getToken(@RequestBody SysUserDto request) {
        return signatureFacade.getToken(request);
    }

    @Auth
    @GetMapping("/auth")
    public void auth() {
        log.info("auth");
    }

    @Auth("No Login")
    @GetMapping("/login")
    public void login() {
        log.info("no login");
    }
}
