package cs.matemaster.standardwebserver.core;

/**
 * @author matemaster
 */
public final class ArrayUtil {

    private ArrayUtil() {
    }

    public static boolean isNotEmpty(Object[] args) {
        return args != null && args.length > 0;
    }
}
