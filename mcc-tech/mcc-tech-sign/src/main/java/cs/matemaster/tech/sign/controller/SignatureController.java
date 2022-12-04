package cs.matemaster.tech.sign.controller;

import cs.matemaster.tech.sign.facade.SignatureFacade;
import cs.matemaster.tech.sign.model.SysUserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@RestController
@AllArgsConstructor
@RequestMapping("/sign")
public class SignatureController {

    private SignatureFacade signatureFacade;

    @PostMapping("getToken")
    public String getToken(@RequestBody SysUserDto request) {
        return signatureFacade.getToken(request);
    }
}
