package cs.matemaster.test;

import cs.matemaster.cases.JavaStreamCase;
import org.junit.jupiter.api.Test;

/**
 * @author matemaster
 */
public class JavaStreamTestCase {

    @Test
    void test1() {
        JavaStreamCase.createStreamStaticMethod();
    }

    @Test
    void test2() {
        JavaStreamCase.vsParallel();
    }
}
