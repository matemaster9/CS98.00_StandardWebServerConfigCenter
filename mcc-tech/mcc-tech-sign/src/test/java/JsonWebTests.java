import cs.matemaster.tech.sign.util.JsonWebUtil;
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
        String secretKey = JsonWebUtil.getSecretKey(SignatureAlgorithm.HS512);
        log.debug(secretKey);
    }

    @Test
    public void test2() {
        Map<String, Object> headers = Maps.<String, Object>of("alg", "none")
                .and("typ", "JWT")
                .build();
        Map<String, Object> claims = Maps.<String, Object>of("SysUser", "1111").build();
        String jws = JsonWebUtil.getJws(headers, claims);
        log.debug(jws);

        Map<String, Object> claimsAsMap = JsonWebUtil.getClaimsAsMap(jws);
        log.debug(claimsAsMap.toString());
    }
}
