import com.google.common.collect.ImmutableMap;
import cs.matemaster.tech.sign.model.SysUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

/**
 * @author matemaster
 */
@Slf4j
public class JsonWebSignatureTestCase {

    @Test
    public void createJws() {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        String hs512Jws = Jwts.builder()
                .setHeader(ImmutableMap.<String, Object>builder()
                        .put("alg", "HS512")
                        .put("typ", "JWT")
                        .build())
                .setClaims(ImmutableMap.<String, Object>builder()
                        .put("iss", "matemaster")
                        .put("sub", "jws")
                        .put("aud", "audience")
                        .put("exp", Date.from(LocalDateTime.now().plusMinutes(1).atZone(ZoneId.systemDefault()).toInstant()))
                        .put("iat", Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
                        .put("nbf", Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
                        .put("jti", UUID.randomUUID().toString().replace("-", ""))
                        .build())
                .signWith(secretKey)
                .compact();

        Jws<Claims> claimsJws = Jwts
                .parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(hs512Jws);

        log.debug(claimsJws.getSignature());
        log.debug(claimsJws.getBody().toString());
        log.debug(claimsJws.getHeader().toString());
    }

    @Test
    public void createPlaintextJws() {
        SysUserDto sysUserDto = new SysUserDto();
        sysUserDto.setUsername("matemaster");
        sysUserDto.setPassword("matemaster");

        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        String jws = Jwts.builder()
                .setHeaderParams(ImmutableMap.of("alg", "HS512", "typ", "JWT"))
                // 此处负载为 non-json
                .setPayload(sysUserDto.toString())
                .signWith(secretKey)
                .compact();

        Jws<String> stringJws = Jwts
                .parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parsePlaintextJws(jws);
        log.debug(stringJws.getHeader().toString());
        log.debug(stringJws.getBody());
        log.debug(stringJws.getSignature());
    }
}
