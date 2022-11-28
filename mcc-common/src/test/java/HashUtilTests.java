import cs.matemaster.standardwebserver.common.util.HashUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author matemaster
 */
public class HashUtilTests {

    @Test
    public void test1() {
        String message = "Hello World";
        System.out.println(HashUtil.hmacMd5AsLong(message));
    }

    @Test
    public void test2() {
        byte[] bytes = HashUtil.hmacMD5SecretKeySpecBytes();
        System.out.println(Arrays.toString(bytes));
    }

    @Test
    public void test3() {
        String message = "Hello World";
        System.out.println(HashUtil.hmacMd5AsBase64(message));
    }

    @Test
    public void test4() {
        String message = "Hello World";
        System.out.println(HashUtil.murmur3AsBase64(message));
        System.out.println(HashUtil.murmur3AsLong(message));
    }
}
