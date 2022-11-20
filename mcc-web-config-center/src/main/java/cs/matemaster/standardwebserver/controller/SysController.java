package cs.matemaster.standardwebserver.controller;

import cs.matemaster.standardwebserver.authority.config.AuthProperties;
import cs.matemaster.standardwebserver.authority.service.AuthServiceSupport;
import cs.matemaster.standardwebserver.authority.util.JsonWebTokenUtil;
import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import cs.matemaster.standardwebserver.common.util.SecurityUtil;
import cs.matemaster.standardwebserver.mapper.SysUserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/system")
@Tag(name = "SysController", description = "系统控制器")
@AllArgsConstructor
public class SysController {

    private SysUserMapper sysUserMapper;
    private AuthProperties authProperties;
    private AuthServiceSupport authServiceSupport;

    @Operation(summary = "welcome")
    @GetMapping("welcome")
    public void welcome() {
        log.info("进入系统");
    }

    @Operation(summary = "获取token")
    @PostMapping("getToken")
    public String getToken(@RequestBody SysUserDto request) {
        String message = JsonUtil.serialize(request);
        String cipher = SecurityUtil.RSAPublicKeyEncryptAsHex(message, authProperties.getRsaPublicKey());
        return authServiceSupport.getToken(cipher, JsonWebTokenUtil.getTokenId());
    }

    @Operation(summary = "register")
    @GetMapping("register")
    public boolean register() {
        SysUserDto sysUserDto = new SysUserDto();
        sysUserDto.setAccount("21869481");
        sysUserDto.setPassword("#OASCBH87");
        return sysUserMapper.insertSysUser(sysUserDto) != 0;
    }
}
