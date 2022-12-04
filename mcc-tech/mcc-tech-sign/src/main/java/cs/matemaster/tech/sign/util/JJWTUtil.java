package cs.matemaster.tech.sign.util;

import cs.matemaster.tech.sign.constant.JsonWebConst;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
public final class JJWTUtil {

    public static final JwtBuilder hmacJwt;
    public static final JwtParser hmacJwtParser;

    private JJWTUtil() {
    }

    public static String getJws(Map<String, Object> header, Map<String, Object> claims) {
        return hmacJwt
                .setHeader(header)
                .setClaims(claims)
                .compact();
    }

    public static Claims getClaims(String jws) {
        return hmacJwtParser.parseClaimsJws(jws).getBody();
    }

    public static Map<String, Object> getClaimsAsMap(String jws) {
        return getClaims(jws).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static String getSecretKey(SignatureAlgorithm algorithm) {
        SecretKey secretKey = Keys.secretKeyFor(algorithm);
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    static {
        hmacJwt = Jwts.builder().signWith(JsonWebConst.getHMACKey());
        hmacJwtParser = Jwts.parserBuilder().setSigningKey(JsonWebConst.getHMACKey()).build();
    }
}
