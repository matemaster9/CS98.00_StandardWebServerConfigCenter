import com.google.common.collect.ImmutableMap;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

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

    /**
     * HS256 HMAC
     * HS384 HMAC
     * HS512 HMAC
     * RS256 RSA
     * RS384 RSA
     * RS512 RSA
     * PS256 RSA
     * PS384 RSA
     * PS512 RSA
     * ES256 ECDSA
     * ES384 ECDSA
     * ES512 ECDSA
     */
    @Test
    public void test2() {
        byte[] hs256Key = "U9ISU_9Z$*9o95m@roLuBFcPPC_6&V5y".getBytes(StandardCharsets.UTF_8);
        SecretKey hs256 = Keys.hmacShaKeyFor(hs256Key);
        log.debug(hs256.getFormat());
        log.debug(hs256.getAlgorithm());
        log.debug(Base64.getEncoder().encodeToString(hs256.getEncoded()));
        log.debug(new String(hs256.getEncoded(), StandardCharsets.UTF_8));
        log.debug(hs256.toString());

        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS512);
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        log.debug(publicKey.getFormat());
        log.debug(publicKey.getAlgorithm());
        log.debug(Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        log.debug(publicKey.toString());

        log.debug(privateKey.getFormat());
        log.debug(privateKey.getAlgorithm());
        log.debug(Base64.getEncoder().encodeToString(privateKey.getEncoded()));
        log.debug(privateKey.toString());
    }

    /**
     * JWT 标准签名算法需要 :
     * 1) HMAC-SHA 算法的 SecretKey 或
     * 2) RSA 算法的私有 RSAKey 或
     * 3) 椭圆曲线算法的私有 ECKey。
     * 指定的密钥类型为 sun.security.rsa.RSAPublicKeyImpl
     */
    @Test
    public void test3() {
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS512);
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        //
        String token = Jwts.builder()
                .setHeader(ImmutableMap.<String, Object>builder()
                        .put("alg", "")
                        .put("typ", "JWT")
                        .build())
                .setClaims(ImmutableMap.<String, Object>builder()
                        .put("SysUserInfo", "")
                        .build())
                .signWith(privateKey)
                .compact();
        log.debug(token);

        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(publicKey).build()
                .parseClaimsJws(token);
        log.debug(claimsJws.getSignature());
        log.debug(claimsJws.getHeader().toString());
        log.debug(claimsJws.getBody().toString());
    }
}
