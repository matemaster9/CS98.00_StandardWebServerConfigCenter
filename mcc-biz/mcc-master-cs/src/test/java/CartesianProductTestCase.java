import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.mastercs.biz.cases.CartesianProductCase;

import java.util.Arrays;
import java.util.List;

/**
 * 求取集合的笛卡尔积
 * 1. 使用lambda
 * 2. guava
 * @author matemaster
 */
public class CartesianProductTestCase {

    @Test
    void test() {
        List<String> cartesianProduct = CartesianProductCase.getCartesianProduct(Arrays.asList("1", "2", "3"), Arrays.asList("A", "B", "C"));
        System.out.println(cartesianProduct);
    }

    @Test
    void test2() {
        List<List<String>> lists = Lists.cartesianProduct(Arrays.asList("1", "2", "3"), Arrays.asList("A", "B", "C"));
        System.out.println(lists);
    }
}
