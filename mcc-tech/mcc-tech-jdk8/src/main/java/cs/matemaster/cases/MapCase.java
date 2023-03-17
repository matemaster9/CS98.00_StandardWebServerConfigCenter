package cs.matemaster.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger log = LoggerFactory.getLogger(MapCase.class);

    /**
     * SortedMap<LocalDate, Integer>
     * key: 日期
     * value: 访问次数
     */
    public static void treeMap() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        SortedMap<LocalDate, Integer> visitCountMap = new TreeMap<>(Comparator.reverseOrder());
        LocalDate firstDayOfCurMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfCurMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        for (LocalDate i = firstDayOfCurMonth; i.isBefore(lastDayOfCurMonth); i = i.plusDays(1)) {
            visitCountMap.put(i, random.nextInt(0, 10000));
        }
        visitCountMap.entrySet().forEach(entry -> log.info(entry.toString()));
    }
}
