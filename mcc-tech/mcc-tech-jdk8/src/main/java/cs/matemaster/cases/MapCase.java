package cs.matemaster.cases;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author matemaster
 */
public class MapCase {

    public static void treeMap() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        SortedMap<LocalDate, Integer> visitCountMap = new TreeMap<>(Comparator.reverseOrder());
        LocalDate firstDayOfCurMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfCurMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        for (LocalDate i = firstDayOfCurMonth; i.isBefore(lastDayOfCurMonth); i = i.plusDays(1)) {
            visitCountMap.put(i, random.nextInt(0, 10000));
        }
        visitCountMap.entrySet().forEach(System.out::println);
    }
}
