package cs.matemaster.thirdlib.guava;


import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author matemaster
 */
@Slf4j
public class SetsDemo {

    @Test
    public void createSets() {
        Sets.newHashSet();
        Sets.newHashSetWithExpectedSize(1024);
    }

    @Test
    public void algebraOfSets() {
        Set<Integer> set1 = Sets.newHashSet(0, 1, 2, 3, 4, 5, 6);
        Set<Integer> set2 = Sets.newHashSet(5, 6, 7, 8, 9, 10, 11);

        Sets.SetView<Integer> intersection = Sets.intersection(set1, set2);
        Sets.SetView<Integer> union = Sets.union(set1, set2);
        Sets.SetView<Integer> difference = Sets.difference(set1, set2);
        Sets.SetView<Integer> symmetricDifference = Sets.symmetricDifference(set1, set2);

        log.debug(intersection.toString());
        log.debug(union.toString());
        log.debug(difference.toString());
        log.debug(symmetricDifference.toString());

        Set<Set<Integer>> combinations = Sets.combinations(set1, 2);
        log.debug(combinations.toString());
        log.debug(String.valueOf(combinations.size()));
        combinations.forEach(System.out::println);

        Sets.powerSet(set1);
    }
}
