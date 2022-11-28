import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;
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

    /**
     * 上传文件（样例代码）
     *
     * @throws QiniuException
     */
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

    /**
     * 自定义上传凭证返回
     */
    @Test
    public void returnBody() {
        String accessKey = "access key";
        String secretKey = "secret key";
        String bucket = "bucket name";

        Auth auth = Auth.create(accessKey, secretKey);

        ReturnBody returnBody = new ReturnBody();
        returnBody.setKey("$(key)");
        returnBody.setHash("$(etag)");
        returnBody.setBucket("$(bucket)");
        returnBody.setFsize("$(fsize)");

        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody", JsonUtil.serialize(returnBody));

        String uploadToken = auth.uploadToken(bucket, null, 36000, putPolicy);
        log.debug(putPolicy.get("returnBody").toString());
        log.debug(uploadToken);
    }

    @Setter
    @Getter
    private static class ReturnBody {
        private String key;
        private String hash;
        private String bucket;
        private String fsize;
    }
}
