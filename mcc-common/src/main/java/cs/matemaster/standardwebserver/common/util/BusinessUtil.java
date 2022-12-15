package cs.matemaster.standardwebserver.common.util;

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
}
