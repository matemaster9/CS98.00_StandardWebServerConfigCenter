import cs.matemaster.standardwebserver.common.util.HashUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author matemaster
 */
public class HashUtilTests {

    @Test
    public void test1() {
        long hello = HashUtil.murmurhash3("Hello111");
        System.out.println(hello);
    }
}
