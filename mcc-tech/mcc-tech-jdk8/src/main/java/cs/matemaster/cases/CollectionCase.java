package cs.matemaster.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author matemaster
 */
public class CollectionCase {

    private static final Logger log = LoggerFactory.getLogger(CollectionCase.class);

    /**
     * 有序集
     */
    public static void treeSet() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SortedSet<String> alphabetSet = new TreeSet<>();
        for (char item : alphabet.toCharArray()) {
            alphabetSet.add(String.valueOf(item));
        }
        alphabetSet.forEach(log::info);
    }


    /**
     * FIFO双端队列
     */
    public static void arrayDeque() {
        String[] nameArray = {"jules.hammes", "gilberte.mayert", "isidro.macgyver", "daryl.bernier", "weldon.kuhn",
                "evangelina.schamberger", "garret.sauer", "maryrose.osinski", "jamison.hintz", "leonardo.green"};
        Deque<String> team = new ArrayDeque<>(16);
        for (String name : nameArray) {
            team.addLast(name);
        }
        team.forEach(log::info);
    }

    /**
     * 大根堆、小根堆
     */
    public static void priorityQueue() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Queue<String> alphabetK = new PriorityQueue<>(16, Comparator.reverseOrder());
        for (char item : alphabet.toCharArray()) {
            alphabetK.add(String.valueOf(item));
        }
        log.info(alphabetK.toString());
        log.info("first element is {}" , alphabetK.element());
    }
}
