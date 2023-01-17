import com.google.common.collect.Sets;
import cs.matemaster.effective_java.Plant;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
public class PlantCase {

    @Test
    public void ordinal2() {

        Plant[] garden = {
                new Plant("watermelon", Plant.LifeCycle.Annual),
                new Plant("lemon", Plant.LifeCycle.Perennial),
                new Plant("apple", Plant.LifeCycle.Biennial)
        };

        Plant.LifeCycle[] values = Plant.LifeCycle.values();
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[values.length];
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = Sets.newHashSet();
        }

        for (Plant plant : garden) {
            plantsByLifeCycle[plant.getLifeCycle().ordinal()].add(plant);
        }

        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n", values[i], plantsByLifeCycle[i]);
        }
    }

    @Test
    public void enumMap() {
        Plant[] garden = {
                new Plant("watermelon", Plant.LifeCycle.Annual),
                new Plant("lemon", Plant.LifeCycle.Perennial),
                new Plant("apple", Plant.LifeCycle.Biennial)
        };

        EnumMap<Plant.LifeCycle, Set<Plant>> setEnumMap = Arrays.stream(garden).collect(
                Collectors.groupingBy(Plant::getLifeCycle, () -> new EnumMap<>(Plant.LifeCycle.class), Collectors.toSet())
        );

        setEnumMap.forEach((key, value) -> System.out.printf("%s: %s%n", key, value));
    }

    @Test
    public void enumMap2() {
        Plant[] garden = {
                new Plant("watermelon", Plant.LifeCycle.Annual),
                new Plant("lemon", Plant.LifeCycle.Perennial),
                new Plant("apple", Plant.LifeCycle.Biennial)
        };

        Map<Plant.LifeCycle, Set<Plant>> setEnumMap = new EnumMap<>(Plant.LifeCycle.class);

        for (Plant plant : garden) {
            setEnumMap.put(plant.getLifeCycle(), Collections.singleton(plant));
        }

        setEnumMap.forEach((key, value) -> System.out.printf("%s: %s%n", key, value));
    }
}
