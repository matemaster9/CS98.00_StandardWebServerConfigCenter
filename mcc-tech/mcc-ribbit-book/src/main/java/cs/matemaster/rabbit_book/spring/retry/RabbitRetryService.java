package cs.matemaster.rabbit_book.spring.retry;

/**
 * @author matemaster
 */
public interface RabbitRetryService {

    /**
     * 三次重试
     */
    void retry3Times();
}
