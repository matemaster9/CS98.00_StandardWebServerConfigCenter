package cs.matemaster.test;

import cs.matemaster.cases.CollectionCase;
import org.junit.jupiter.api.Test;

/**
 * @author matemaster
 */
public class CollectionTestCase {

    @Test
    void test() {
        CollectionCase.treeSet();
    }

    @Test
    void test2() {
        CollectionCase.arrayDeque();
    }

    @Test
    void test3() {
        CollectionCase.priorityQueue();
    }
}
