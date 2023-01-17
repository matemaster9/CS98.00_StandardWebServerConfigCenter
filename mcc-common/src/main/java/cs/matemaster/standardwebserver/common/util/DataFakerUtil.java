package cs.matemaster.standardwebserver.common.util;

import com.google.common.collect.ImmutableMap;
import cs.matemaster.standardwebserver.common.constant.MockDataTypeEnum;
import net.datafaker.Faker;
import net.datafaker.providers.base.Address;
import net.datafaker.providers.base.Job;
import net.datafaker.providers.base.Name;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author matemaster
 */
public final class DataFakerUtil {

    private static final Faker zhCNFaker = new Faker(Locale.CHINA);
    private static final Faker enFaker = new Faker(Locale.ENGLISH);

    public static final ThreadLocalRandom localRandom = ThreadLocalRandom.current();

    private static final Map<Class<?>, Object> zhCNFakerMap;
    private static final Map<Class<?>, Object> enFakerMap;

    private DataFakerUtil() {
    }

    public static String getRandomValue(MockDataTypeEnum dataTypeEnum) {
        switch (dataTypeEnum) {
            case City:
                return ((Address) zhCNFakerMap.get(Address.class)).city();
            case ChineseName:
                return ((Name) zhCNFakerMap.get(Name.class)).name();
            case EnglishName:
                return ((Name) enFakerMap.get(Name.class)).name();
            case Job:
                return ((Job) zhCNFakerMap.get(Job.class)).title();
            default:
                return null;
        }
    }

    public static int getRandomInteger(int origin, int bound) {
        return localRandom.nextInt(origin, bound);
    }

    public static String getRandomDeptId() {
        StringBuilder builder = new StringBuilder(5);
        for (int i = 0, limit = 5; i < limit; i++) {
            builder.append(getRandomInteger(0, 9));
        }
        return builder.toString();
    }

    public static BigDecimal getRandomBigDecimal(String origin, String bound) {
        double originDouble = Double.parseDouble(origin);
        double boundDouble = Double.parseDouble(bound);

        double randomDouble = localRandom.nextDouble(originDouble, boundDouble);
        return BigDecimal.valueOf(randomDouble).setScale(2, RoundingMode.HALF_UP);
    }

    public static List<Integer> getRandomList(int capacity) {
        return IntStream
                .generate(localRandom::nextInt)
                .boxed()
                .limit(capacity)
                .collect(Collectors.toList());
    }

    static {
        zhCNFakerMap = ImmutableMap.<Class<?>, Object>builder()
                .put(Address.class, zhCNFaker.address())
                .put(Name.class, zhCNFaker.name())
                .put(Job.class, zhCNFaker.job())
                .build();

        enFakerMap = ImmutableMap.<Class<?>, Object>builder()
                .put(Address.class, enFaker.address())
                .build();
    }
}
