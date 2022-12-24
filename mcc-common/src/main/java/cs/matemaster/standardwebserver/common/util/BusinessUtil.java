package cs.matemaster.standardwebserver.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

/**
 * @author matemaster
 */
public final class BusinessUtil {

    private BusinessUtil() {
    }

    public static boolean isTrue(Object arg) {
        return Boolean.TRUE.equals(arg);
    }

    public static boolean isFalse(Object arg) {
        return Boolean.FALSE.equals(arg);
    }

    public static int getQueryOffset(int totalCount, int size) {
        return totalCount % size == 0 ? totalCount / size : totalCount / size + 1;
    }

    public static String kebabToUpperCamel(String kebabCase) {
        String copy = kebabCase.toLowerCase(Locale.ROOT);
        String[] split = StringUtils.split(copy, '-');
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            builder.append(StringUtils.capitalize(split[i]));
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
        for (int i = 0; i < split.length; i++) {
            builder.append(StringUtils.capitalize(split[i]));
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
}
