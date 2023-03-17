import cs.matemaster.standardwebserver.common.util.DataFakerUtil;
import org.junit.Test;

import java.util.List;
import java.util.Locale;

/**
 * @author matemaster
 */
public class DataFakerUtilTests {

    @Test
    public void test() {
        List<String> nameList = DataFakerUtil.getNameList(10, Locale.ENGLISH);
        System.out.println(nameList);
    }
}
