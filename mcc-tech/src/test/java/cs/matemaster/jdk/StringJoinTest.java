package cs.matemaster.jdk;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

/**
 * @author matemaster
 */
public class StringJoinTest {

    @Benchmark
    public void measureStringJoin(Blackhole bh) {
        String str = "";

        for (int i = 0, limit = 1000; i < limit; i++) {
            str += i;
        }

        bh.consume(str);
    }

    @Benchmark
    public void measureStringBuild(Blackhole bh) {
        StringBuilder builder = new StringBuilder(1000);

        for (int i = 0, limit = 1000; i < limit; i++) {
            builder.append(i);
        }

        bh.consume(builder.toString());
    }
}
