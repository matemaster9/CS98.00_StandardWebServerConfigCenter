package cs.matemaster.standardwebserver.common.util;

import com.google.common.collect.ImmutableMap;
import cs.matemaster.standardwebserver.common.constant.MockDataTypeEnum;
import net.datafaker.Faker;
import net.datafaker.providers.base.Address;
import net.datafaker.providers.base.Job;
import net.datafaker.providers.base.Name;

import java.util.Locale;
import java.util.Map;

/**
 * @author matemaster
 */
public final class DataFakerUtil {

    private static final Faker zhCNFaker = new Faker(Locale.CHINA);
    private static final Faker enFaker = new Faker(Locale.ENGLISH);

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
