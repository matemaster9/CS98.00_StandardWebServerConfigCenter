import cs.matemaster.tech.sign.util.JJWTUtil;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

/**
 * @author matemaster
 */
@Slf4j
public class JsonWebTests {

    @Test
    public void test1() {
        String secretKey = JJWTUtil.getSecretKey(SignatureAlgorithm.HS512);
        log.debug(secretKey);
    }

    @Test
    public void test2() {
        Map<String, Object> headers = Maps.<String, Object>of("alg", "none")
                .and("typ", "JWT")
                .build();
        Map<String, Object> claims = Maps.<String, Object>of("SysUser", "1111").build();
        String jws = JJWTUtil.getJws(headers, claims);
        log.debug(jws);

        Map<String, Object> claimsAsMap = JJWTUtil.getClaimsAsMap(jws);
        log.debug(claimsAsMap.toString());
    }
}
