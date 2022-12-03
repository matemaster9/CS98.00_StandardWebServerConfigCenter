import cs.matemaster.standardwebserver.common.util.HashUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author matemaster
 */
@Slf4j
public class HashUtilTests {

    @Test
    public void test1() {
        long hello = HashUtil.murmurhash3("Hello111");
        System.out.println(hello);
    }

    @Test
    public void test2() {
        log.info(HashUtil.sipHash24AsBase64("Hello World"));
        log.info(HashUtil.hmacMd5AsBae64("Hello World"));
        log.info(HashUtil.hmacSHA1AsBase64("Hello World"));
        log.info(HashUtil.hmacSHA256AsBase64("Hello World"));
        log.info(HashUtil.hmacSHA512AsBase64("Hello World"));
        log.info(HashUtil.murmurhash3AsBase64("Hello World"));
    }
}
