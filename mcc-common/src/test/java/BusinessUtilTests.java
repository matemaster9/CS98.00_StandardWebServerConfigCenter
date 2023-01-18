import com.google.common.base.Stopwatch;
import cs.matemaster.standardwebserver.common.util.BusinessUtil;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author matemaster
 */
public class BusinessUtilTests {

    @Test
    public void name() {
        System.out.println(BusinessUtil.kebabToUpperCamel("mate-master"));
        System.out.println(BusinessUtil.kebabToLowerCamel("mate-master"));
        System.out.println(BusinessUtil.snakeToLowerCamel("mate_master"));
        System.out.println(BusinessUtil.snakeToUpperCamel("mate_master"));
    }

    @Test
    public void sleep() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        BusinessUtil.sleep(100, TimeUnit.MILLISECONDS);
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
