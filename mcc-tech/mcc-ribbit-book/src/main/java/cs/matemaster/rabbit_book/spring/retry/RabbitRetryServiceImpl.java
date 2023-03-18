package cs.matemaster.rabbit_book.spring.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * 注解@Retryable定义重试的条件和行为
 * 注解@Recover定义重试失败后的回调行为
 *
 * @author matemaster
 */
@Slf4j
@Service
public class RabbitRetryServiceImpl implements RabbitRetryService {

    @Override
    @Retryable(value = Exception.class, maxAttempts = 2, backoff = @Backoff(delay = 1000, multiplier = 1.5))
    public void retry3Times() {

    }


    @Recover
    public void callback(Throwable exception) {
        log.error("retry fail, error message: {}", exception.getMessage());
    }
}
