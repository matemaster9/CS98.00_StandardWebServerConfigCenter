import cs.matemaster.standardwebserver.common.util.BusinessUtil;
import org.junit.Test;

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
}
