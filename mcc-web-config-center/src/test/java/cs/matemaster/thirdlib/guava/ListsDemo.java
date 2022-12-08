package cs.matemaster.thirdlib.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author matemaster
 */
@Slf4j
public class ListsDemo {

    @Test
    void createList() {
        Lists.newArrayList();
        Lists.newArrayList("master", "chat");

        Lists.asList("OnePlusArrayList<>", new String[0]);
        Lists.asList("first", "second", new String[]{"TwoPlusArrayList<>"});
    }

    @Test
    void partition() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }
        List<List<Integer>> partition = Lists.partition(numbers, 10);
        List<Integer> subList = partition.get(0);
        subList.add(1);
        log.debug(subList.toString());
        log.debug(numbers.toString());
    }


    @Test
    void charactersOf() {
        ImmutableList<Character> characters = Lists.charactersOf("matemaster");
        log.debug(characters.toString());
    }

    @Test
    void name() {
        List<Integer> numbers = Lists.asList(0, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        List<String> alphabet = Lists.asList("A", new String[]{"B", "C", "D"});
        List<List<Object>> cartesianProduct = Lists.cartesianProduct(alphabet, numbers);
        cartesianProduct.forEach(System.out::println);
    }
}
