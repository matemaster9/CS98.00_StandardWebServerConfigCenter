package cs.matemaster.standardwebserver.infrastructure.redis;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

/**
 * @author matemaster
 */
@Component
@AllArgsConstructor
public class RedisClientSupportImpl implements RedisClientSupport {

    private Jedis jedisClient;

    @Override
    public void setMessage(String prefix, String key, String message) {
        jedisClient.set(generateKey(prefix, key), message);
    }

    @Override
    public void setExpiredMessage(String prefix, String key, String expiredMessage, long millisecond) {
        jedisClient.set(generateKey(prefix, key), expiredMessage, SetParams.setParams().px(millisecond));
    }

    @Override
    public String getMessage(String prefix, String key) {
        return jedisClient.get(generateKey(prefix, key));
    }
}
