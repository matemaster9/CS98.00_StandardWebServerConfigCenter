package cs.matemaster.effective_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author matemaster
 */
public class PrefListsToArrays {

    public static void main(String[] args) {
        /*
         * ArrayStoreException
         * new PrefListsToArrays().covariant();
         */

    }

    public void covariant() {
        Object[] objectArray = new Integer[10];
        // ArrayStoreException
        Arrays.fill(objectArray, "java.lang.String");
    }

    public void varList() {
        /*
         * List<Object> objectList = new ArrayList<String>();
         */
    }
}
