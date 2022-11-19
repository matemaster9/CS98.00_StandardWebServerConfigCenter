package cs.matemaster.standardwebserver.infrastructure.redis;

/**
 * @author matemaster
 */
public interface RedisClientSupport {

    void setMessage(String prefix, String key, String message);

    void setExpiredMessage(String prefix, String key, String expiredMessage, long millisecond);

    String getMessage(String prefix, String key);

    default String generateKey(String prefix, String key) {
        return String.join(":", prefix, key);
    }
}
