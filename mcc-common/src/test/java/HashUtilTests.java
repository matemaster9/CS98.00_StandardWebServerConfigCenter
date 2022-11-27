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
        System.out.println(HashUtil.hmacMD5AsLong(message));
    }

    @Test
    public void test2() {
        byte[] bytes = HashUtil.hmacMD5SecretKeySpecBytes();
        System.out.println(Arrays.toString(bytes));
    }
}
