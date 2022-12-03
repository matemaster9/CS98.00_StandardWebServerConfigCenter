package cs.matemaster.tech.sign.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import cs.matemaster.tech.sign.service.JsonWebTokenSupport;

import java.util.Map;

/**
 * @author matemaster
 */
public class JavaJwtImpl implements JsonWebTokenSupport {

    @Override
    public String getJWS(Map<String, Object> header, Map<String, Object> claims) {


        return null;
    }
}
