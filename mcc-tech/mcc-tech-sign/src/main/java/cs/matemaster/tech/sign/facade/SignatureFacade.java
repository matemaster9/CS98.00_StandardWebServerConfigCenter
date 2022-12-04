package cs.matemaster.tech.sign.facade;

import cs.matemaster.tech.sign.model.SysUserDto;

/**
 * @author matemaster
 */
public interface SignatureFacade {
    String getToken(SysUserDto sysUserDto);
}
