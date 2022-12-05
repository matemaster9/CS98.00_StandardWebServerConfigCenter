package cs.matemaster.tech.sign.constant;

import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

/**
 * @author matemaster
 */
public final class JsonWebConst {

    private JsonWebConst() {
        throw new UnsupportedOperationException();
    }

    /**
     * HS512密钥
     */
    public static final String HMACKey = "IyPy+F9qMVA0s2wYVbzvwHyFQot+NBRQn/tsS0nYRGs4K+NwQCVWP7C12QnHVRqzrmFrCwSPJV+Uz8ISZE5M5w==";

    /**
     * jwt允许时间差
     */
    public static final long AllowedClockSkewSeconds = 100L;

    /**
     * token的redis键前缀
     */
    public static final String RedisPrefix = "SysToken";

    public static final String SysUserClaim = "SysUser";

    /**
     * access token有效时间 30分钟
     */
    public static final long AccessExpiration = 30L;

    /**
     * refresh token有效时间 3小时
     */
    public static final long RefreshExpiration = 3L;

    /**
     * redis键过期时间 3小时 与refresh token有效时间保持一致
     */
    public static final long SysTokenExpireTime = 3 * 60 * 60 * 100L;

    public static Key getHMACKey() {
        return Keys.hmacShaKeyFor(HMACKey.getBytes(StandardCharsets.UTF_8));
    }
}
