package cs.matemaster.standardwebserver.infrastructure.redis;

/**
 * @author matemaster
 */
public interface RedisClientComponent {

    void setMessage(String prefix, String key, String message);

    void setExpiredMessage(String prefix, String key, String expiredMessage, long millisecond);

    String getMessage(String prefix, String key);
}
