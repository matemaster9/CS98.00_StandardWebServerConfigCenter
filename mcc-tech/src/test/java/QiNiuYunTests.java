import com.qiniu.util.Auth;
import org.junit.Test;

/**
 * @author matemaster
 */
public class QiNiuYunTests {

    @Test
    public void test1() {
        String accessKey = "access key";
        String secretKey = "secret key";
        String bucket = "bucket name";

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
    }
}
