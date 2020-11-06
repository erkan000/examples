package example.redis;

import java.time.Duration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class ConnectionPool {
	
	private static final JedisPoolConfig poolConfig = buildPoolConfig();
	
	public static final JedisPool jedisPool = new JedisPool(poolConfig, "localhost", 6379, 2000, "pass");
		 
	private static final JedisPoolConfig buildPoolConfig() {
	    final JedisPoolConfig poolConfig = new JedisPoolConfig();
	    poolConfig.setMaxTotal(64);
	    poolConfig.setMaxIdle(128);
	    poolConfig.setMinIdle(16);
	    poolConfig.setTestOnBorrow(true);
	    poolConfig.setTestOnReturn(true);
	    poolConfig.setTestWhileIdle(true);
	    poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
	    poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
	    poolConfig.setNumTestsPerEvictionRun(3);
	    poolConfig.setBlockWhenExhausted(true);
	    return poolConfig;
	}

}
