package cs.matemaster.standardwebserver.service;

import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;

/**
 * @author matemaster
 */
public interface AuthService {
    String sign(SysUserDto sysUser);
}
