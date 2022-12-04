package cs.matemaster.tech.sign.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

/**
 * @author matemaster
 */
@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "json-web")
public class JsonWebProperties {

    private String hs512SecretKey;

    private static final Base64.Decoder decoder = Base64.getDecoder();

    public Key getHS512Key() {
        byte[] decode = decoder.decode(hs512SecretKey);
        return new SecretKeySpec(decode, "HmacSHA512");
    }
}
