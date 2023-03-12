import com.google.common.util.concurrent.RateLimiter;

import java.time.LocalDateTime;

/**
 * @author matemaster
 */
public class LimitingCase {


    public static void guavaRateLimiter() {
        System.out.println("start time: " + LocalDateTime.now());
        RateLimiter limiter = RateLimiter.create(1.0);
        for (int i = 0, count = 10 ; i <  count; i++) {
            limiter.acquire();
            System.out.println("tasking... " + i);
        }
        System.out.println("end time: " + LocalDateTime.now());
    }
}
