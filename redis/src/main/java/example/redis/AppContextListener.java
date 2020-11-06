package example.redis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.redis.ConnectionPool;
import example.redis.RedisSubscriber;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

@WebListener
public class AppContextListener implements ServletContextListener{
	
	private final ExecutorService executor = Executors.newFixedThreadPool(1);
	private final JedisPubSub subscriber = new RedisSubscriber();
	private static Logger logger = LoggerFactory.getLogger(AppContextListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try (Jedis jedis = ConnectionPool.jedisPool.getResource()){
			logger.info("Context Destroying");
			subscriber.unsubscribe();
			executor.shutdown();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {			
			Runnable runnableTask = () -> {
				try (Jedis jedis = ConnectionPool.jedisPool.getResource()){
					jedis.subscribe(subscriber , "test");
					logger.info("Subscribe blocking method has finished.");
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			};
			executor.execute(runnableTask);
			logger.info("Context Initialized!");			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}	

}
