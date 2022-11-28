package cs.matemaster.standardwebserver.common.util;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

import javax.annotation.Nonnull;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Objects;

/**
 * @author matemaster
 */
public final class HashUtil {

    private static final byte[] HmacMD5SecretKeySpec = {-81, 83, 3, -98, 27, -76, 52, 108, -120, 66, 17, 96, 92, -64, 125, -44};
    public static final Base64.Encoder encoderBase64 = Base64.getEncoder();

    private HashUtil() {
    }

    public static long hmacMd5AsLong(Object arg) {
        return Objects.isNull(arg) ? 0L : hmacMD5(arg).asLong();
    }

    public static String hmacMd5AsBase64(Object arg) {
        return Objects.isNull(arg) ? "null" : encoderBase64.encodeToString(hmacMD5(arg).asBytes());
    }

    public static HashCode hmacMD5(@Nonnull Object arg) {
        return Hashing
                .hmacMd5(HmacMD5SecretKeySpec)
                .hashString(arg.toString(), StandardCharsets.UTF_8);
    }

    public static byte[] hmacMD5SecretKeySpecBytes() {
        return Objects.requireNonNull(getHmacMD5SecretKeySpec()).getEncoded();
    }

    private static SecretKeySpec getHmacMD5SecretKeySpec() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
            keyGenerator.init(128);
            return new SecretKeySpec(keyGenerator.generateKey().getEncoded(), "HmacMD5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static long murmur3AsLong(Object arg) {
        return arg == null ? 0L : murmur3_128(arg).asLong();
    }

    public static String murmur3AsBase64(Object arg) {
        return arg == null ? "null" : encoderBase64.encodeToString(murmur3_128(arg).asBytes());
    }

    public static HashCode murmur3_128(@Nonnull Object arg) {
        return Hashing
                .murmur3_128()
                .hashString(arg.toString(), StandardCharsets.UTF_8);
    }
}
