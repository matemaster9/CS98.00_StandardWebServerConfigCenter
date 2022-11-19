package cs.matemaster.standardwebserver.authority.service;

import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import io.jsonwebtoken.Claims;

import java.util.Date;

/**
 * @author matemaster
 */
public interface AuthServiceSupport {

    boolean isValidSysUser(SysUserDto sysUser);

    Claims getClaims(String jwt);

    String refreshToken(Claims clientClaims);

    String getToken(String cipher, String tokenId);
}
