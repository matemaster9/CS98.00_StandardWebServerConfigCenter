import com.google.common.collect.ImmutableMap;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.crypto.SecretKey;
import java.util.Collections;

/**
 * @author matemaster
 */
@Slf4j
public class JsonWebTokenTests {

    @Test
    public void test1() {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        String token = Jwts.builder()
                .setHeader(ImmutableMap.<String, Object>builder()
                        .put("alg", "")
                        .put("typ", "JWT")
                        .build())
                .setClaims(ImmutableMap.<String, Object>builder()
                        .put("SysUserInfo", "")
                        .build())
                .signWith(secretKey)
                .compact();
        log.debug(token);

        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(secretKey).build()
                .parseClaimsJws(token);
        log.debug(claimsJws.getSignature());
        log.debug(claimsJws.getHeader().toString());
        log.debug(claimsJws.getBody().toString());
    }
}
