package cs.matemaster.tech.sign.service.impl;

import cs.matemaster.tech.sign.service.JsonWebTokenSupport;

import java.util.Map;

/**
 * @author matemaster
 */
public abstract class AbstractJsonWebTokenSupport implements JsonWebTokenSupport {
    @Override
    public String getSymmetricSecretKey() {
        throw new UnsupportedOperationException("getSymmetricSecretKey is not suppoerted");
    }

    @Override
    public Map<String, String> getAsymmetricSecretKey() {
        throw new UnsupportedOperationException("getAsymmetricSecretKey is not suppoerted");
    }

    @Override
    public String sign(String payload, Map<String, Object> registryClaims) {
        throw new UnsupportedOperationException("sign is not suppoerted");
    }

    @Override
    public String verify(String jws) {
        throw new UnsupportedOperationException("verify is not suppoerted");
    }

    @Override
    public String encrypt(String payload) {
        throw new UnsupportedOperationException("encrypt is not suppoerted");
    }

    @Override
    public String decrypt(String jwe) {
        throw new UnsupportedOperationException("decrypt is not suppoerted");
    }
}
