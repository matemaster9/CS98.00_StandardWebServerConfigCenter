package cs.matemaster.cases;

import com.google.common.util.concurrent.RateLimiter;

import java.time.LocalDateTime;

/**
 * guava限流解决方案测试案例
 * @author matemaster
 */
public class LimitingCase {


    /**
     * 每秒钟放行
     */
    public static void permitsPerSecond() {
        System.out.println("start time: " + LocalDateTime.now());
        RateLimiter limiter = RateLimiter.create(1.0);
        for (int i = 0, count = 10 ; i <  count; i++) {
            limiter.acquire();
            System.out.println("tasking... " + i);
        }
        System.out.println("end time: " + LocalDateTime.now());
    }
}
