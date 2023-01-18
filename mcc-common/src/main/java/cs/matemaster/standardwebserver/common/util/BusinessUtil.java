package cs.matemaster.standardwebserver.common.util;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author matemaster
 */
public final class BusinessUtil {

    private static final String ALPHABET_NUMBER = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private static final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    private BusinessUtil() {
    }

    public static boolean isTrue(Object arg) {
        return Boolean.TRUE.equals(arg);
    }

    public static boolean isFalse(Object arg) {
        return Boolean.FALSE.equals(arg);
    }

    public static int getQueryOffset(int totalCount, int size) {
        throw new UnsupportedOperationException("错误逻辑");
    }

    public static int getQueryStartIndex(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }

    public static String kebabToUpperCamel(String kebabCase) {
        String copy = kebabCase.toLowerCase(Locale.ROOT);
        String[] split = StringUtils.split(copy, '-');
        StringBuilder builder = new StringBuilder();
        for (String s : split) {
            builder.append(StringUtils.capitalize(s));
        }
        return builder.toString();
    }

    public static String kebabToLowerCamel(String kebabCase) {
        String copy = kebabCase.toLowerCase(Locale.ROOT);
        String[] split = StringUtils.split(copy, '-');
        StringBuilder builder = new StringBuilder();
        builder.append(split[0]);
        for (int i = 1; i < split.length; i++) {
            builder.append(StringUtils.capitalize(split[i]));
        }
        return builder.toString();
    }

    public static String snakeToUpperCamel(String snakeCase) {
        String copy = snakeCase.toLowerCase(Locale.ROOT);
        String[] split = StringUtils.split(copy, '_');
        StringBuilder builder = new StringBuilder();
        for (String s : split) {
            builder.append(StringUtils.capitalize(s));
        }
        return builder.toString();
    }

    public static String snakeToLowerCamel(String snakeCase) {
        String copy = snakeCase.toLowerCase(Locale.ROOT);
        String[] split = StringUtils.split(copy, '_');
        StringBuilder builder = new StringBuilder();
        builder.append(split[0]);
        for (int i = 1; i < split.length; i++) {
            builder.append(StringUtils.capitalize(split[i]));
        }
        return builder.toString();
    }

    public static String buildSQLLikeStr(String arg) {
        if (StringUtils.isBlank(arg)) {
            return arg;
        }

        return "%" + arg + "%";
    }

    public static String getBizSequence(String prefix) {
        if (StringUtils.isBlank(prefix)) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        String timestamp = DateTimeUtil.format(LocalDateTime.now(), "yyyyMMddHHmmss");
        String randomString = getRandomString();

        return builder.append(prefix).append(timestamp).append(randomString).toString();
    }

    private static String getRandomString() {
        int limit = 9;
        StringBuilder builder = new StringBuilder(limit);
        char[] chars = ALPHABET_NUMBER.toCharArray();
        for (int i = 0; i < limit; i++) {
            builder.append(chars[threadLocalRandom.nextInt(0, chars.length)]);
        }
        return builder.toString();
    }

    @SneakyThrows
    public static void sleep(long timeout, TimeUnit unit) {
        unit.sleep(timeout);
    }
}
