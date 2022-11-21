package cs.matemaster.standardwebserver.controller;

import com.google.common.collect.ImmutableList;
import cs.matemaster.standardwebserver.authority.config.AuthProperties;
import cs.matemaster.standardwebserver.authority.service.AuthServiceSupport;
import cs.matemaster.standardwebserver.authority.util.JsonWebTokenUtil;
import cs.matemaster.standardwebserver.common.model.dto.excel.Global500CompanyDto;
import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.common.util.EasyExcelUtil;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @Operation(summary = "解析excel")
    @PostMapping("parseGlobal500")
    public List<Global500CompanyDto> parseGlobal500(@RequestParam(name = "file") MultipartFile request) throws IOException {
        return EasyExcelUtil.toGenericList(request.getInputStream(), Global500CompanyDto.class);
    }

    @Operation(summary = "解析excel")
    @PostMapping("exportGlobal500")
    public void exportGlobal500(@RequestBody List<Global500CompanyDto> request) throws IOException {
        List<List<String>> head = ImmutableList.of(
                Collections.singletonList("排名"),
                Collections.singletonList("公司名称"),
                Collections.singletonList("营收"),
                Collections.singletonList("利润"),
                Collections.singletonList("国家")
        );
        List<List<Object>> dataList = request.stream()
                .map(item -> {
                    List<Object> data = new ArrayList<>();
                    data.add(item.getRank());
                    data.add(item.getCompanyName());
                    data.add(item.getIncome());
                    data.add(item.getProfit());
                    data.add(item.getCountry());
                    return data;
                }).collect(Collectors.toList());
        EasyExcelUtil.exportExcel("global500", head, dataList);
    }
}
