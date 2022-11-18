package cs.matemaster.standardwebserver.controller;

import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
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

    @Operation(summary = "welcome")
    @GetMapping("welcome")
    public void welcome() {
        log.info("进入系统");
    }

    @Operation(summary = "获取token")
    @PostMapping("getToken")
    public String getToken(@RequestBody SysUserDto request) {
        return null;
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
