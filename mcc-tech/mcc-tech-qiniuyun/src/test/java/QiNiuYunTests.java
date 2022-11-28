import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author matemaster
 */
@Slf4j
public class QiNiuYunTests {

    @Test
    public void simpleUploadCertificate() {
        String accessKey = "access key";
        String secretKey = "secret key";
        String bucket = "bucket name";

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        log.debug(upToken);
    }
}
