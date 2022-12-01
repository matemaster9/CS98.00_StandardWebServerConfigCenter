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

/**
 * @author matemaster
 */
public final class JsonWebUtil {

    public static final JwtBuilder hmacJwt;
    public static final JwtParser hmacJwtParser;

    private JsonWebUtil() {
    }

    public static String getJws(Map<String, Object> headers, Map<String, Object> claims) {
        return hmacJwt
                .setHeader(headers)
                .setClaims(claims)
                .compact();
    }

    public static Claims getClaims(String jws) {
        return hmacJwtParser.parseClaimsJws(jws).getBody();
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
