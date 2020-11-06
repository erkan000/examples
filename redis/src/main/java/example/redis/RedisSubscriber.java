package example.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPubSub;

public class RedisSubscriber extends JedisPubSub {

	private static Logger logger = LoggerFactory.getLogger(RedisSubscriber.class);

	@Override
    public void onMessage(String channel, String message) {
	    logger.info("Message arrived, Channel: {}, Message is: {}", channel, message);
    }

	@Override
    public void onPMessage(String pattern, String channel, String message) {

	}

	@Override
    public void onSubscribe(String channel, int subscribedChannels) {
		logger.info("Subscribed to " + channel); 
	}

	@Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
		logger.info("Unsubscribed from " + channel); 
	}

	@Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {

	}

    @Override
	public void onPSubscribe(String pattern, int subscribedChannels) {

	}
}
