package cs.matemaster.standardwebserver.aop.auth;

import cs.matemaster.standardwebserver.authority.util.JsonWebTokenUtil;
import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import cs.matemaster.standardwebserver.infrastructure.redis.RedisClientSupport;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

        String tokenId = clientClaims.get(AuthConstants.TokenId, String.class);
        String cipher = clientClaims.get(AuthConstants.CipherUser, String.class);
        String json = redisClientSupport.getMessage("SysWebToken", tokenId);
        SysWebToken sysWebToken = JsonUtil.deserialize(json, SysWebToken.class);

        if (Objects.isNull(sysWebToken)) {
            throw new AuthException(MccErrorEnum.MCC_TOKEN_EXPIRE);
        }

        Claims serverRefreshClaims = JsonWebTokenUtil.jwtParserBuilder
                .build().parseClaimsJws(sysWebToken.getRefreshToken())
                .getBody();

        if (!tokenId.equals(serverRefreshClaims.get(AuthConstants.TokenId, String.class))
                || !cipher.equals(serverRefreshClaims.get(AuthConstants.CipherUser, String.class))) {
            throw new AuthException(MccErrorEnum.MCC_CLAIMS_NOT_MATCH);
        }

        return getToken(cipher, tokenId);
    }

    @Override
    public String getToken(String cipher, String tokenId) {

        DefaultClaims defaultClaims = new DefaultClaims();
        defaultClaims.put(AuthConstants.TokenId, tokenId);
        defaultClaims.put(AuthConstants.CipherUser, cipher);

        LocalDateTime now = LocalDateTime.now();

        String accessToken = JsonWebTokenUtil.jwtBuilder
                .addClaims(defaultClaims)
                .setIssuedAt(new Date())
                .setExpiration(toDate(now.plusSeconds(AuthConstants.AccessExpireSecond)))
                .compact();

        String refreshToken = JsonWebTokenUtil.jwtBuilder
                .addClaims(defaultClaims)
                .setIssuedAt(new Date())
                .setExpiration(toDate(now.plusSeconds(AuthConstants.RefreshExpireSecond)))
                .compact();

        SysWebToken sysWebToken = new SysWebToken(accessToken, refreshToken);
        redisClientSupport.setExpiredMessage("SysWebToken", tokenId, JsonUtil.serialize(sysWebToken), AuthConstants.RefreshExpireSecond * 1000);

        return sysWebToken.getAccessToken();
    }

    private Date toDate(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
}
