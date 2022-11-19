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
}
