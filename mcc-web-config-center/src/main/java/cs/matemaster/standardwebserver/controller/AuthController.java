package cs.matemaster.standardwebserver.controller;

import cs.matemaster.standardwebserver.common.model.dto.sys.EncryptedSysUser;
import cs.matemaster.standardwebserver.facade.AuthFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@Slf4j
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Tag(name = "AuthController", description = "认证控制器")
public class AuthController {

    private AuthFacade authFacade;

    @Operation(summary = "验证")
    @PostMapping("sign")
    public String sign(@RequestBody EncryptedSysUser request) {
        return authFacade.sign(request);
    }
}
