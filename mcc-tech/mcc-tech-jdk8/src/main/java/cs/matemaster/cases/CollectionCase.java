package cs.matemaster.cases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author matemaster
 */
public class CollectionCase {

    private static final Logger log = LoggerFactory.getLogger(CollectionCase.class);

    public static void treeSet() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SortedSet<String> alphabetSet = new TreeSet<>();
        for (char item : alphabet.toCharArray()) {
            alphabetSet.add(String.valueOf(item));
        }
        alphabetSet.forEach(log::info);
    }
}
