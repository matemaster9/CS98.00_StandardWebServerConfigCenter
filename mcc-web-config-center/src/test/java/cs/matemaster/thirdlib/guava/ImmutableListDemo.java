package cs.matemaster.thirdlib.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

/**
 * @author matemaster
 */
public class ImmutableListDemo {

    @Test
    public void create() {
        ImmutableList<Integer> immutableList1 = ImmutableList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        ImmutableList<Integer> immutableList2 = ImmutableList.copyOf(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        ImmutableList<Integer> immutableList3 = ImmutableList.<Integer>builder().add(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).build();
    }
}
