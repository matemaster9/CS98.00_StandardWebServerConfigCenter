import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author matemaster
 */
@Slf4j
public class QiNiuYunTests {

    /**
     * 简单上传凭证
     */
    @Test
    public void simpleUploadCertificate() {
        String accessKey = "access key";
        String secretKey = "secret key";
        String bucket = "bucket name";

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        log.debug(upToken);
    }

    /**
     * 覆盖文件上传凭证
     */
    @Test
    public void coverUploadCertificate() {
        String accessKey = "access key";
        String secretKey = "secret key";
        String bucket = "bucket name";
        String key = "file key";

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, key);
        log.debug(upToken);
    }

    @Test
    public void qiNiuYunConfig() {
        Region region = Region.region0();
        Configuration configuration = new Configuration(region);
        UploadManager uploadManager = new UploadManager(configuration);
    }
}
