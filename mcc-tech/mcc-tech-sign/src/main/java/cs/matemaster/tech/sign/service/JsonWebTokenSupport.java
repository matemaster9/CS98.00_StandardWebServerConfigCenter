package cs.matemaster.tech.sign.service;

import cs.matemaster.tech.sign.constant.JsonWebAlgorithmEnum;

import java.util.Map;

/**
 * @author matemaster
 */
public interface JsonWebTokenSupport {

    String getSymmetricSecretKey(JsonWebAlgorithmEnum algorithm);

    Map<String, String> getAsymmetricSecretKey();

    String sign(Map<String, Object> payload);

    Map<String, Object> verify(String jws);

    String encrypt(Map<String, Object> payload);

    Map<String, Object> decrypt(String jwe);
}
