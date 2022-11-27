package cs.matemaster.tech.easyexcel;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @author matemaster
 */
public class PathUtil {

    public static String getClasspath() {
        URL systemResource = ClassLoader.getSystemResource("");
        try {
            return URLDecoder.decode(systemResource.getPath(), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {

        }
        return null;
    }
}
