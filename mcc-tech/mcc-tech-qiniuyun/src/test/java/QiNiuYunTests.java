import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @Test
    public void current() {
        log.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")));
    }

    @Test
    public void upload() throws QiniuException {
        String file = "/Users/matemaster/Develop/GitHub项目/CS98.00_M1_OOS/mcc-tech/mcc-tech-qiniuyun/src/main/resources/application.yml";
        String accessKey = "access key";
        String secretKey = "secret key";
        String bucket = "bucket name";
        String key = "file key";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, key);
        Region region = Region.region0();
        Configuration configuration = new Configuration(region);
        UploadManager uploadManager = new UploadManager(configuration);
        Response response = uploadManager.put(file, key, upToken);
        String responseBodyString = response.bodyString();
        DefaultPutRet defaultPutRet = JsonUtil.deserialize(responseBodyString, DefaultPutRet.class);
    }
}
