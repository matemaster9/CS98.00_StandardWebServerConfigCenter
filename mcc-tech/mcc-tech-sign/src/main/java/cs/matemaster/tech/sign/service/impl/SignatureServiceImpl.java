package cs.matemaster.tech.sign.service.impl;

import com.google.common.collect.ImmutableMap;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import cs.matemaster.standardwebserver.infrastructure.redis.RedisClientSupport;
import cs.matemaster.tech.sign.model.SysToken;
import cs.matemaster.tech.sign.model.SysUserDto;
import cs.matemaster.tech.sign.service.JsonWebTokenSupport;
import cs.matemaster.tech.sign.service.SignatureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author matemaster
 */
@Service
@AllArgsConstructor
public class SignatureServiceImpl implements SignatureService {

    private JsonWebTokenSupport jsonWebTokenSupport;
    private RedisClientSupport redisClientSupport;

    @Override
    public String issueToken(SysUserDto sysUserDto) {
        ImmutableMap<String, Object> accessPayload = ImmutableMap.<String, Object>builder()
                .put("jti", "")
                .put("exp", new Date())
                .put("iat", new Date())
                .put("iss", "mcc")
                .put("nbf", new Date())
                .put("SysUser", Objects.requireNonNull(JsonUtil.serialize(sysUserDto)))
                .build();

        ImmutableMap<String, Object> refreshPayload = ImmutableMap.<String, Object>builder()
                .put("jti", "")
                .put("exp", new Date())
                .put("iat", new Date())
                .put("iss", "mcc")
                .put("nbf", new Date())
                .put("SysUser", Objects.requireNonNull(JsonUtil.serialize(sysUserDto)))
                .build();

        String accessToken = jsonWebTokenSupport.sign(accessPayload);
        String refreshToken = jsonWebTokenSupport.sign(refreshPayload);

        SysToken sysToken = new SysToken();
        sysToken.setAccessToken(accessToken);
        sysToken.setRefreshToken(refreshToken);

        redisClientSupport.setExpiredMessage("SysToken", (String) refreshPayload.get("jti"), JsonUtil.serialize(sysToken), 1000);
        return accessToken;
    }
}
