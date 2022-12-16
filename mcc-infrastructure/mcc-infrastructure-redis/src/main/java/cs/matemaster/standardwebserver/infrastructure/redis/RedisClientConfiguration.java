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
public class RedisClientConfiguration {

    private RedisConfig redisConfig;

    @Bean
    public Jedis jedisClient() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setLifo(redisConfig.isInfo());
        config.setMaxIdle(redisConfig.getMaxIdle());
        config.setMinIdle(redisConfig.getMinIdle());
        config.setMaxTotal(redisConfig.getMaxTotal());
        config.setFairness(redisConfig.isFairness());
        config.setJmxEnabled(redisConfig.isJmxEnabled());
        config.setTestWhileIdle(redisConfig.isTestWhileIdle());
        config.setBlockWhenExhausted(redisConfig.isBlockWhenExhausted());

        try (JedisPool jedisPool = new JedisPool(config, redisConfig.getHost(), redisConfig.getPort(), 2000, redisConfig.getPassword())) {
            return jedisPool.getResource();
        }
    }
}
