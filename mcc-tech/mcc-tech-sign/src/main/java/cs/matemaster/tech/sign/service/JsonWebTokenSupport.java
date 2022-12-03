package cs.matemaster.tech.sign.service;

import cs.matemaster.tech.sign.constant.JsonWebAlgorithmEnum;

import java.security.Key;
import java.security.KeyPair;
import java.util.Map;

/**
 * @author matemaster
 */
public interface JsonWebTokenSupport {

    String getSymmetricSecretKey(JsonWebAlgorithmEnum algorithm);

    Map<String, String> getAsymmetricSecretKey();

    String sign(String payload, Map<String, Object> registryClaims);

    String verify(String jws);

    String encrypt(String payload);

    String decrypt(String jwe);
}
