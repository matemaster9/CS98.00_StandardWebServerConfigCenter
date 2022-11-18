package cs.matemaster.standardwebserver.common.util;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Objects;

/**
 * @author matemaster
 */
public class SecurityUtil {

    private static final String MD5 = "MD5";
    private static final String saltValue = "MASTER";
    private static final String RSA = "RSA";
    private static final Base64.Encoder encoderBase64 = Base64.getEncoder();
    private static final Base64.Decoder decoderBase64 = Base64.getDecoder();

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

    public static String RSAPublicKeyEncrypt(String plainText, String publicKey) {
        try {

            PublicKey rsaPublicKey = Objects.requireNonNull(toRSAPublicKey(publicKey), "无效密钥");
            Cipher cipher = Cipher.getInstance(RSA);
            cipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
            byte[] bytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(bytes);
        } catch (Exception ignore) {
            return null;
        }
    }

    public static String RSAPrivateKeyEncrypt(String plainText, String privateKey) {
        try {
            PrivateKey rsaPrivateKey = Objects.requireNonNull(toRSAPrivateKey(privateKey), "无效密钥");
            Cipher cipher = Cipher.getInstance(RSA);
            cipher.init(Cipher.ENCRYPT_MODE, rsaPrivateKey);
            byte[] bytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(bytes);
        } catch (Exception ignore) {
            return null;
        }
    }

    public static String RSAPublicKeyDecrypt(String cipher, String publicKey) {
        try {
            PublicKey rsaPublicKey = Objects.requireNonNull(toRSAPublicKey(publicKey), "无效密钥");
            Cipher crypto = Cipher.getInstance(RSA);
            crypto.init(Cipher.DECRYPT_MODE, rsaPublicKey);
            byte[] bytes = crypto.doFinal(cipher.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(bytes);
        } catch (Exception ignore) {
            return null;
        }
    }

    public static String RSAPrivateKeyDecrypt(String cipher, String privateKey) {
        try {
            PrivateKey rsaPrivateKey = Objects.requireNonNull(toRSAPrivateKey(privateKey), "无效密钥");
            Cipher crypto = Cipher.getInstance(RSA);
            crypto.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
            byte[] bytes = crypto.doFinal(cipher.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(bytes);
        } catch (Exception ignore) {
            return null;
        }
    }

    private static PublicKey toRSAPublicKey(String message) {
        try {
            byte[] encodePublicKey = encoderBase64.encode(message.getBytes(StandardCharsets.UTF_8));
            PKCS8EncodedKeySpec encodedKeySpec = new PKCS8EncodedKeySpec(encodePublicKey);
            return KeyFactory.getInstance(RSA).generatePublic(encodedKeySpec);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static PrivateKey toRSAPrivateKey(String message) {
        try {
            byte[] encodePrivateKey = encoderBase64.encode(message.getBytes(StandardCharsets.UTF_8));
            PKCS8EncodedKeySpec encodedKeySpec = new PKCS8EncodedKeySpec(encodePrivateKey);
            return KeyFactory.getInstance(RSA).generatePrivate(encodedKeySpec);
        } catch (Exception ignore) {
            return null;
        }
    }
}
