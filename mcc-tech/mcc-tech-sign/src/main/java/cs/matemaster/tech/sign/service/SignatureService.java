package cs.matemaster.tech.sign.service;

import cs.matemaster.tech.sign.model.SysUserDto;

/**
 * @author matemaster
 */
public interface SignatureService {
    String issueToken(SysUserDto sysUserDto);
}
