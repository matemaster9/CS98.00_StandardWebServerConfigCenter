package cs.matemaster.tech.sign.service;

import cs.matemaster.tech.sign.model.SysUserDto;

import java.util.Map;

/**
 * @author matemaster
 */
public interface SignatureService {
    String issueToken(SysUserDto sysUserDto);

    String renewToken(Map<String, Object> payload);
}
