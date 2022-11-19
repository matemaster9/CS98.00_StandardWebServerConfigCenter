package cs.matemaster.standardwebserver.authority.util;


import com.google.common.collect.ImmutableMap;
import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import cs.matemaster.standardwebserver.common.util.SecurityUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

/**
 * @author matemaster
 */
public final class JsonWebTokenUtil {

    private JsonWebTokenUtil() {
    }

    public static final JwtBuilder jwtBuilder;
    public static final JwtParserBuilder jwtParserBuilder;

    public static String getToken(SysUserDto sysUserDto) {
        String message = JsonUtil.serialize(sysUserDto);
        String encryptedMessage = SecurityUtil.MD5Encrypt(message);

        ImmutableMap<String, Object> headerMap = ImmutableMap.of("typ", "JWT", "alg", "HS256");
        ImmutableMap<String, Object> claimMap = ImmutableMap.<String, Object>builder().put("SysUser", encryptedMessage).build();

        return jwtBuilder.setHeaderParams(headerMap).addClaims(claimMap).compact();
    }

    public static SysUserDto getMessage(String jwt) {
        Claims body = jwtParserBuilder.build().parseClaimsJws(jwt).getBody();
        String message = body.get("SysUser", String.class);
        return JsonUtil.deserialize(message, SysUserDto.class);
    }

    public static Claims getClaims(String jwt) {
        return jwtParserBuilder.build().parseClaimsJws(jwt).getBody();
    }


    static {
        String secretKey = "Tf%Dof40yhNkxKHyi-0!5kIkxTQ1lAaqp=jnp$OPX2bjS&h$KNcN=EoJTvISn3=-ufX&YgsN&93D4ckU7HPQC9BFBu9E%aHtH+";
        SecretKey hmacShaKey = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        jwtBuilder = Jwts.builder().signWith(hmacShaKey, SignatureAlgorithm.HS256);
        jwtParserBuilder = Jwts.parserBuilder().setSigningKey(hmacShaKey);
    }
}
