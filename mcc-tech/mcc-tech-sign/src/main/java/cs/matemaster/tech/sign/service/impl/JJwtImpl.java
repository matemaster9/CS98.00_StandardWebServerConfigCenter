package cs.matemaster.tech.sign.service.impl;

import cs.matemaster.tech.sign.config.JsonWebProperties;
import cs.matemaster.tech.sign.service.JsonWebTokenSupport;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.lang.Maps;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author matemaster
 */
@Component
@Primary
@AllArgsConstructor
public class JJwtImpl extends AbstractJsonWebTokenSupport implements JsonWebTokenSupport {

    private JsonWebProperties jsonWebProperties;

    private static final Map<String, Object> HEADER = Maps.<String, Object>of("alg", "HS512")
            .and("typ", "JWT")
            .build();

    @Override
    public String sign(Map<String, Object> payload) {

        return Jwts.builder()
                .setHeader(HEADER)
                .setClaims(payload)
                .signWith(jsonWebProperties.getHS512Key())
                .compact();
    }

    @Override
    public Map<String, Object> verify(String jws) {
        return super.verify(jws);
    }
}
