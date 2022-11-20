package cs.matemaster.standardwebserver.common.util;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;

/**
 * @author matemaster
 */
public class SecurityUtil {

    private static final String MD5 = "MD5";
    private static final String saltValue = "MASTER";
    private static final String RSA = "RSA";
    private static final String AES = "AES";
    public static final Base64.Encoder encoderBase64 = Base64.getEncoder();
    public static final Base64.Decoder decoderBase64 = Base64.getDecoder();

    public static String MD5EncryptAsHex(String plainText) {
        try {
            MessageDigest alg = MessageDigest.getInstance(MD5);
            String message = String.join("_", saltValue, plainText);
            byte[] encryptBytes = alg.digest(message.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(encryptBytes);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String RSAPublicKeyEncryptAsHex(String plainText, String publicKey) {
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

    public static String RSAPrivateKeyEncryptAsHex(String plainText, String privateKey) {
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

    public static String RSAPublicKeyDecryptAsHex(String cipher, String publicKey) {
        try {
            PublicKey rsaPublicKey = Objects.requireNonNull(toRSAPublicKey(publicKey), "无效密钥");
            Cipher crypto = Cipher.getInstance(RSA);
            crypto.init(Cipher.DECRYPT_MODE, rsaPublicKey);
            byte[] bytes = crypto.doFinal(Hex.decodeHex(cipher));
            return Hex.encodeHexString(bytes);
        } catch (Exception ignore) {
            return null;
        }
    }

    public static String RSAPrivateKeyDecryptAsHex(String cipher, String privateKey) {
        try {
            PrivateKey rsaPrivateKey = Objects.requireNonNull(toRSAPrivateKey(privateKey), "无效密钥");
            Cipher crypto = Cipher.getInstance(RSA);
            crypto.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
            byte[] bytes = crypto.doFinal(Hex.decodeHex(cipher));
            return Hex.encodeHexString(bytes);
        } catch (Exception ignore) {
            return null;
        }
    }

    public static Map<String, String> getBase64RSAKeyPair(PasswordLength level) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
            keyPairGenerator.initialize(level.getCode());
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            return ImmutableMap.<String, String>builder()
                    .put("PublicKeyStr", encoderBase64.encodeToString(keyPair.getPublic().getEncoded()))
                    .put("PrivateKeyStr", encoderBase64.encodeToString(keyPair.getPrivate().getEncoded()))
                    .build();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static PublicKey toRSAPublicKey(String base64Message) {
        try {
            byte[] encodePublicKey = decoderBase64.decode(base64Message.getBytes(StandardCharsets.UTF_8));
            X509EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(encodePublicKey);
            return KeyFactory.getInstance(RSA).generatePublic(encodedKeySpec);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static PrivateKey toRSAPrivateKey(String base64Message) {
        try {
            byte[] encodePrivateKey = decoderBase64.decode(base64Message.getBytes(StandardCharsets.UTF_8));
            PKCS8EncodedKeySpec encodedKeySpec = new PKCS8EncodedKeySpec(encodePrivateKey);
            return KeyFactory.getInstance(RSA).generatePrivate(encodedKeySpec);
        } catch (Exception ignore) {
            return null;
        }
    }

    public static String AESEncryptAsHex(String plainText, String secretKey) {
        try {
            Key secretKeySpec = Objects.requireNonNull(toAESSecretKey(secretKey), "无效密钥");
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] bytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(bytes);
        } catch (Exception ignore) {
            return null;
        }
    }

    public static String AESDecryptAsHex(String cipher, String secretKey) {
        try {
            Key secretKeySpec = Objects.requireNonNull(toAESSecretKey(secretKey), "无效密钥");
            Cipher crypto = Cipher.getInstance(AES);
            crypto.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] bytes = crypto.doFinal(Hex.decodeHex(cipher));
            return Hex.encodeHexString(bytes);
        } catch (Exception ignore) {
            return null;
        }
    }

    /**
     * AES 加密 plainText -> cipherBase64
     * @param plainText
     * @param secretKey
     * @return
     */
    public static String AESEncryptAsBase64(String plainText, String secretKey) {
        try {
            Key secretKeySpec = Objects.requireNonNull(toAESSecretKey(secretKey), "无效密钥");
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] bytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return encoderBase64.encodeToString(bytes);
        } catch (Exception ignore) {
            return null;
        }
    }

    /**
     * AES 解密 cipherBase64 -> plainText
     * @param cipherBase64
     * @param secretKey
     * @return
     */
    public static String AESDecrypt(String cipherBase64, String secretKey) {
        try {
            Key secretKeySpec = Objects.requireNonNull(toAESSecretKey(secretKey), "无效密钥");
            Cipher crypto = Cipher.getInstance(AES);
            crypto.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] bytes = crypto.doFinal(decoderBase64.decode(cipherBase64));
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception ignore) {
            return null;
        }
    }

    public static String getBase64AESSecretKey(PasswordLength aes) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
            keyGenerator.init(aes.getCode());
            SecretKey secretKey = keyGenerator.generateKey();
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), AES);
            return encoderBase64.encodeToString(secretKeySpec.getEncoded());
        } catch (NoSuchAlgorithmException ignore) {
            return null;
        }
    }

    private static Key toAESSecretKey(String base64Message) {
        byte[] bytes = decoderBase64.decode(base64Message);
        return new SecretKeySpec(bytes, AES);
    }

    public enum PasswordLength {
        Level_1(1024),
        Level_2(2048),
        Level_3(3072),
        Level_4(4092),
        AES_1(128),
        AES_2(192),
        AES_3(256);

        private final int length;

        PasswordLength(int length) {
            this.length = length;
        }

        public int getCode() {
            return length;
        }
    }
}
