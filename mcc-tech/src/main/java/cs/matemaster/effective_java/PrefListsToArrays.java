package cs.matemaster.effective_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author matemaster
 */
public class PrefListsToArrays {

    {
        System.out.println("构造代码块");
    }

    public static void main(String[] args) {
        /*
         * ArrayStoreException
         * new PrefListsToArrays().covariant();
         */
        new PrefListsToArrays().listVSArr();

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

    public void listVSArr() {
        long sum1 = 0L;
        long sum2 = 0L;

        Random random = new Random();

        int[] arr = random.ints(100_000_000).toArray();

        List<Integer> collect = random.ints(100_000_000).boxed().collect(Collectors.toList());

        long now1 = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
        }
        System.out.println(System.currentTimeMillis() - now1);

        long now2 = System.currentTimeMillis();
        int sum = collect.stream().mapToInt(t -> t).sum();
        System.out.println(System.currentTimeMillis() - now2);
    }
}
