package cs.matemaster.standardwebserver.aop.auth;

import cs.matemaster.standardwebserver.authority.util.JsonWebTokenUtil;
import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.infrastructure.redis.RedisClientSupport;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author matemaster
 */
@Service
@AllArgsConstructor
public class AuthServiceSupportImpl implements AuthServiceSupport {

    private RedisClientSupport redisClientSupport;

    @Override
    public boolean isValidSysUser(SysUserDto sysUser) {
        String cache = redisClientSupport.getMessage("SysUser", sysUser.getAccount());
        return Objects.nonNull(cache);
    }

    @Override
    public Claims getClaims(String jwt) {
        return JsonWebTokenUtil.getClaims(jwt);
    }

    @Override
    public String refreshToken(Claims clientClaims) {
        return null;
    }

    @Override
    public String getToken(String cipher, Date nbf, String tokenId) {
        return null;
    }
}
