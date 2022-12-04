package cs.matemaster.standardwebserver.common.util;

import javax.annotation.Nonnull;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author matemaster
 */
public final class DateTimeUtil {

    private DateTimeUtil() {
    }

    public static Date convertLocalDateTimeToDate(@Nonnull LocalDateTime dateTime) {
        Instant instant = dateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
}
