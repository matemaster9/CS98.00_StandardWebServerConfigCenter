package cs.matemaster.standardwebserver.authority.service;

import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import io.jsonwebtoken.Claims;

/**
 * @author matemaster
 */
public interface AuthServiceSupport {

    boolean isValidSysUser(SysUserDto sysUser);

    Claims getClaims(String jwt);

    String refreshToken(Claims clientClaims);

    String getToken(String cipher, String tokenId);
}
