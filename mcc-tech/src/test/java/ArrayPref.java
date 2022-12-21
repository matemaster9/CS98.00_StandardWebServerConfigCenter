


import com.google.common.base.Stopwatch;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
public class ArrayPref {


    private static Random rand;

    static {
        try {
            rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException ignore) {
            rand = new Random();
        }
    }

    /**
     * 数组便利建议使用下标
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = rand.ints(100_000_000).toArray();
        List<Integer> collect = rand.ints(100_000_000).boxed().collect(Collectors.toList());

        Stopwatch started = Stopwatch.createStarted();
        long sum1 = 0L;
        for (int j : arr) {
            sum1 += j;
        }
        System.out.println("sum1: " + sum1);
        System.out.println(started.elapsed(TimeUnit.SECONDS));

        started.reset().start();
        int sum2 = collect.stream().mapToInt(t -> t).sum();
        System.out.println("sum2: " + sum2);
        System.out.println(started.elapsed(TimeUnit.SECONDS));
    }
}
