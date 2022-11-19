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

    private RedisProperties redisProperties;

    @Bean
    public Jedis jedisClient() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setLifo(redisProperties.isInfo());
        config.setMaxIdle(redisProperties.getMaxIdle());
        config.setMinIdle(redisProperties.getMinIdle());
        config.setMaxTotal(redisProperties.getMaxTotal());
        config.setFairness(redisProperties.isFairness());
        config.setJmxEnabled(redisProperties.isJmxEnabled());
        config.setTestWhileIdle(redisProperties.isTestWhileIdle());
        config.setBlockWhenExhausted(redisProperties.isBlockWhenExhausted());

        try (JedisPool jedisPool = new JedisPool(config, redisProperties.getHost(), redisProperties.getPort(), 2000, redisProperties.getPassword())) {
            return jedisPool.getResource();
        }
    }
}
