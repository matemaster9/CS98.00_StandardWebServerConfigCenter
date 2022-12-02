package cs.matemaster.tech.sign.service;

import java.util.Map;

/**
 * @author matemaster
 */
public interface JsonWebTokenSupport {

    String getJWS(Map<String, Object> header, Map<String, Object> claims);


}
