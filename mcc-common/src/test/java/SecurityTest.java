import cs.matemaster.standardwebserver.common.util.SecurityUtil;
import org.junit.Test;

import java.util.Map;

/**
 * @author matemaster
 */
public class SecurityTest {

    @Test
    public void name() {
        Map<String, String> keyPair = SecurityUtil.getKeyPair(SecurityUtil.PasswordLength.Level_1);
        System.out.println(keyPair.get("PublicKeyStr"));
        System.out.println(keyPair.get("PrivateKeyStr"));
    }
}
