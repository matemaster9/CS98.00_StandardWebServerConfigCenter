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
}
