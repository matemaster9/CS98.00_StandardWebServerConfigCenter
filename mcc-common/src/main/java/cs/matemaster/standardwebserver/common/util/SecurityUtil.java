package cs.matemaster.standardwebserver.common.util;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author matemaster
 */
public class SecurityUtil {

    private static final String MD5 = "MD5";
    private static final String saltValue = "MASTER";

    public static String MD5Encrypt(String plainText) {
        try {
            MessageDigest alg = MessageDigest.getInstance(MD5);
            String message = String.join("_", saltValue, plainText);
            byte[] encryptBytes = alg.digest(message.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(encryptBytes);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
