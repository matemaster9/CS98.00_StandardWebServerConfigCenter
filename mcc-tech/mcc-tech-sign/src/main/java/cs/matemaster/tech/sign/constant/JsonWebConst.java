package cs.matemaster.tech.sign.constant;

import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

/**
 * @author matemaster
 */
public final class JsonWebConst {

    private JsonWebConst() {
        throw new UnsupportedOperationException();
    }

    public static String HMACKey = "IyPy+F9qMVA0s2wYVbzvwHyFQot+NBRQn/tsS0nYRGs4K+NwQCVWP7C12QnHVRqzrmFrCwSPJV+Uz8ISZE5M5w==";

    public static Key getHMACKey() {
        return Keys.hmacShaKeyFor(HMACKey.getBytes(StandardCharsets.UTF_8));
    }
}
