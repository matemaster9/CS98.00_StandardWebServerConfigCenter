package cs.matemaster.standardwebserver.logger;

import lombok.extern.slf4j.Slf4j;

/**
 * @author matemaster
 */
@Slf4j
public final class UserLogger {

    private UserLogger() {
    }

    public static void debug(Object arg) {
        log.debug(String.valueOf(arg));
    }

    public static void info(Object arg) {
        log.info(String.valueOf(arg));
    }

    public static void error(Object arg) {
        log.error(String.valueOf(arg));
    }

    public static void warn(Object arg) {
        log.warn(String.valueOf(arg));
    }
}
