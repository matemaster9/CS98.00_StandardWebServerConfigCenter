package cs.matemaster.standardwebserver.infrastructure.redis;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author matemaster
 */
@Configuration
@AllArgsConstructor
@ConditionalOnProperty(value = "infrastructure.redis.enable", havingValue = "true")
public class RedisClientConfig {

    private RedisClientProps redisClientProps;

    @Bean
    public Jedis jedisClient() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setLifo(redisClientProps.isInfo());
        config.setMaxIdle(redisClientProps.getMaxIdle());
        config.setMinIdle(redisClientProps.getMinIdle());
        config.setMaxTotal(redisClientProps.getMaxTotal());
        config.setFairness(redisClientProps.isFairness());
        config.setJmxEnabled(redisClientProps.isJmxEnabled());
        config.setTestWhileIdle(redisClientProps.isTestWhileIdle());
        config.setBlockWhenExhausted(redisClientProps.isBlockWhenExhausted());

        try (JedisPool jedisPool = new JedisPool(config, redisClientProps.getHost(), redisClientProps.getPort(), 2000, redisClientProps.getPassword())) {
            return jedisPool.getResource();
        }
    }
}
