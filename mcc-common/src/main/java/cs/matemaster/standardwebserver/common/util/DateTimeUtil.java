package cs.matemaster.standardwebserver.common.util;

import javax.annotation.Nonnull;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
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

    public static Date convertLocalDateToDate(@Nonnull LocalDate dateTime) {
        Instant instant = dateTime.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static String format(ChronoLocalDate datetime, String pattern) {
        return datetime.format(DateTimeFormatter.ofPattern(pattern));
    }
}
