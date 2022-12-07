package jjwt;

import cs.matemaster.tech.sign.util.JJWTUtil;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author matemaster
 */
@Slf4j
public class JJWTUtilTests {

    @Test
    public void name() {
        log.debug(JJWTUtil.getSecretKey(SignatureAlgorithm.HS512));
        log.debug(JJWTUtil.getSecretKeyPair(SignatureAlgorithm.ES512).toString());
    }
}
