package jjwt;

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
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Base64;
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

        log.debug(hs512Jws);

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

    @Test
    public void signAndValidate() {
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

    /**
     * jjwt支持对称和非对称两种三类：HMAC RSASSA ECDSA
     */
    @Test
    public void generateSecretKey() {
        // HMAC using SHA-512
        Keys.secretKeyFor(SignatureAlgorithm.HS512);
        // ECDSA using P-521 and SHA-512
        Keys.keyPairFor(SignatureAlgorithm.ES512);
        // RSASSA-PKCS-v1_5 using SHA-512
        Keys.keyPairFor(SignatureAlgorithm.RS512);
    }

    @Test
    public void secretKeyDetail() {
        SecretKey hs512 = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        log.debug(Arrays.toString(hs512.getEncoded()));
        log.debug(Base64.getEncoder().encodeToString(hs512.getEncoded()));

        KeyPair es512 = Keys.keyPairFor(SignatureAlgorithm.ES512);
        PublicKey es512Public = es512.getPublic();
        PrivateKey es512Private = es512.getPrivate();

        log.debug(Arrays.toString(es512Public.getEncoded()));
        log.debug(Base64.getEncoder().encodeToString(es512Public.getEncoded()));
        log.debug(Arrays.toString(es512Private.getEncoded()));
        log.debug(Base64.getEncoder().encodeToString(es512Private.getEncoded()));

        KeyPair rs512 = Keys.keyPairFor(SignatureAlgorithm.RS512);
        PublicKey rs512Public = rs512.getPublic();
        PrivateKey rs512Private = rs512.getPrivate();

        log.debug(Arrays.toString(rs512Public.getEncoded()));
        log.debug(Base64.getEncoder().encodeToString(rs512Public.getEncoded()));
        log.debug(Arrays.toString(rs512Private.getEncoded()));
        log.debug(Base64.getEncoder().encodeToString(rs512Private.getEncoded()));
    }
}
