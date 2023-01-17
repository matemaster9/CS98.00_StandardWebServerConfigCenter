package cs.matemaster.jdk;

import cs.matemaster.standardwebserver.common.util.DataFakerUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author matemaster
 */
public class CollectionsCase {


    @Test
    public void empty() {
        Collections.emptyList();
        Collections.emptyMap();
        Collections.emptySet();
        Collections.emptySortedSet();
        Collections.emptySortedMap();
        Collections.emptyNavigableMap();
        Collections.emptyNavigableSet();
    }


    @Test
    public void singleton() {
        Collections.singleton("set");
        Collections.singletonList("list");
        Collections.singletonMap("key", "value");
    }

    @Test
    public void sort() {
        List<Integer> randomList = DataFakerUtil.getRandomList(10);
        System.out.println(randomList);
        Collections.sort(randomList);
        System.out.println(randomList);
    }

    @Test
    public void search() {
        List<Integer> randomList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        randomList.sort(Comparator.comparingInt(t -> t));
        int key = 4;
        int index = Collections.binarySearch(randomList, key);
        System.out.println(index);


    }

    @Test
    public void search_2() {
        List<String> sortedRandomList = new ArrayList<>(Arrays.asList("mate", "tom", "kitty", "jackson", "google-json"));
        String key = "tom";
        Comparator<String> stringComparator = Comparator.comparingInt(String::length);
        sortedRandomList.sort(stringComparator);
        System.out.println(sortedRandomList);
        int index = Collections.binarySearch(sortedRandomList, key, stringComparator);
        System.out.println(index);
    }

    @Test
    public void shuffle() {
        List<Integer> sorted = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(sorted, ThreadLocalRandom.current());
        System.out.println(sorted);
    }

    @Test
    public void swap() {
        List<String> tech = new ArrayList<>(Arrays.asList("mate", "tom", "kitty", "jackson", "google-json"));
        int startIndex = 0;
        int endIndex = tech.size() - 1;
        Collections.swap(tech, startIndex, endIndex);
        System.out.println(tech);
    }

    @Test
    public void reverse() {
        List<String> tech = new ArrayList<>(Arrays.asList("fastjson", "spring", "springboot", "jackson", "google-json"));
        Collections.reverse(tech);
        System.out.println(tech);
    }

    @Test
    public void replaceAll() {
        List<String> tech = new ArrayList<>(Arrays.asList("fastjson", "tech", "tech", "tech", "google-json"));
        String oldVal = "tech";
        String newVal = "java";
        boolean result = Collections.replaceAll(tech, oldVal, newVal);
        System.out.println(result);
        System.out.println(tech);
    }

    @Test
    public void fill() {
        List<String> tech = new ArrayList<>(Arrays.asList("fastjson", "spring", "springboot", "jackson", "google-json"));
        String filledElement = "tech";
        Collections.fill(tech, filledElement);
        System.out.println(tech);
    }

    @Test
    public void mostVal() {
        List<String> tech = new ArrayList<>(Arrays.asList("fastjson", "spring", "springboot", "jackson", "google-json"));
        Comparator<String> stringComparator = Comparator.comparingInt(String::length);
        System.out.println(Collections.max(tech));
        System.out.println(Collections.max(tech, stringComparator));
        System.out.println(Collections.min(tech));
        System.out.println(Collections.min(tech, stringComparator));
    }

    @Test
    public void sync() {
        List<String> list = new ArrayList<>(Arrays.asList("fastjson", "spring", "springboot", "jackson", "google-json"));
        List<String> strings = Collections.synchronizedList(list);
    }

    @Test
    public void unmodifiable() {
        
    }
}
