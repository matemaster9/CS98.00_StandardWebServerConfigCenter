import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import cs.matemaster.tech.qiniuyun.QiNiuYunApplication;
import cs.matemaster.tech.qiniuyun.config.QiNiuYunProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

/**
 * @author matemaster
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = QiNiuYunApplication.class)
public class QiNiuYunApplicationTests {

    @Autowired
    private QiNiuYunProperties qiNiuYunProperties;

    @Test
    public void upload() throws QiniuException {
        String file = "/Users/matemaster/Develop/GitHub项目/CS98.00_M1_OOS/mcc-tech/mcc-tech-qiniuyun/src/main/resources/application.yml";
        Auth auth = Auth.create(qiNiuYunProperties.getAccessKey(), qiNiuYunProperties.getSecretKey());
        String upToken = auth.uploadToken(qiNiuYunProperties.getBucket());
        Region region = Region.region0();
        Configuration configuration = new Configuration(region);
        UploadManager uploadManager = new UploadManager(configuration);
        Response response = uploadManager.put(file, null, upToken);
        String responseBodyString = response.bodyString();
        DefaultPutRet defaultPutRet = JsonUtil.deserialize(responseBodyString, DefaultPutRet.class);
        log.info(Objects.requireNonNull(defaultPutRet).toString());
    }
}
