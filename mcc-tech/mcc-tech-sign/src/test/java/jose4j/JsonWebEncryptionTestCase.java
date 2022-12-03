package jose4j;

import lombok.extern.slf4j.Slf4j;
import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithm;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.JoseException;
import org.junit.Test;

/**
 * @author matemaster
 */
@Slf4j
public class JsonWebEncryptionTestCase {

    @Test
    public void encryptJwt() throws JoseException {
        AesKey key = new AesKey(ByteUtil.randomBytes(16));
        JsonWebEncryption encryptedJwt = new JsonWebEncryption();
        encryptedJwt.setPayload("Hello JWE");
        encryptedJwt.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.A128KW);
        encryptedJwt.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256);
        encryptedJwt.setKey(key);
        String compactSerialization = encryptedJwt.getCompactSerialization();
        log.debug(compactSerialization);
    }
}
