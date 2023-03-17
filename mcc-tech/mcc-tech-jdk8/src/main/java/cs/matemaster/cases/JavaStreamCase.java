package cs.matemaster.cases;

import com.google.common.base.Stopwatch;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author matemaster
 */
public class JavaStreamCase {

    /**
     * Stream#of
     * Stream#generate
     * Stream#iterate
     */
    public static void createStreamStaticMethod() {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        Stream<Double> stream2 = Stream.generate(Math::random).limit(10);
        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 1).limit(10);

        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
        stream3.forEach(System.out::println);
    }

    /**
     *
     */
    public static void vsParallel() {
        List<Integer> values = IntStream.iterate(0, JavaStreamCase::increment)
                .limit(700_000)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(values);

        Stopwatch stopwatch = Stopwatch.createStarted();
        Optional<Integer> first = values.stream().filter(JavaStreamCase::hasMoreVal).findFirst();
        System.out.println("consumer time: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        Optional<Integer> first2 = values.parallelStream().filter(JavaStreamCase::hasMoreVal).findFirst();
        System.out.println("consumer time: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        first.ifPresent(firstValue -> System.out.println("firstValue: " + firstValue));
        first2.ifPresent(firstValue -> System.out.println("firstValue: " + firstValue));
    }

    private static int increment(int value) {
        return value + 1;
    }

    private static boolean hasMoreVal(int val) {
        return val > 6666;
    }
}
