package rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Amqp {

	private Connection connection;
	private Channel channel;

	public void initializeClient() {
		try {
			if (connection == null) {
				ConnectionFactory factory = new ConnectionFactory();
				factory.setHost("127.0.0.1");
				factory.setPort(5672);
				factory.setUsername("guest");
				factory.setPassword("guest");
				factory.setAutomaticRecoveryEnabled(true);
				factory.setConnectionTimeout(1000);
				this.connection = factory.newConnection();
			}
			if (channel == null) {
				this.channel = connection.createChannel();
			}
		} catch (IOException | TimeoutException e) {
			LOGGER.error("Failed to initialize client instance {}.", e.getLocalizedMessage());
		}
	}

	public boolean isConnected() {
		if (channel == null || connection == null) {
			return false;
		}
		return channel.isOpen() && connection.isOpen();
	}

	public synchronized boolean publishMessage(String exchange, String queue, String message, String routingKey) {
		if (isConnected()) {
			try {
				channel.exchangeDeclare(exchange, BuiltinExchangeType.TOPIC, true);
				LOGGER.info(
						"Publishing message with exchange: \"" + exchange + "queue: " + queue + "Message: "
						+ message);
				channel.queueDeclare(queue, true, false, true, null);
				channel.queueBind(queue, exchange, routingKey);
				channel.basicPublish(exchange, routingKey, null, message.getBytes());
				return true;
			} catch (Exception e) {
				LOGGER.error(e.getLocalizedMessage(), e);
			}
		}
		return false;
	}

	public void registerAmqpMessageListener(String exchange, String queue) {
		try {
			if (channel != null && channel.isOpen()) {
				LOGGER.info("Subscribing to topic: \"" + exchange + "\" queue: " + queue);
				channel.exchangeDeclare(exchange, "topic", true);
				channel.queueDeclare(queue, true, false, true, null);
				channel.queueBind(queue, exchange, queue);
				channel.basicConsume(queue, true, deliverCallbackAmqp, consumerTag -> {
				});
			}

		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage(), e);
		}
	}

	DeliverCallback deliverCallbackAmqp = (consumerTag, delivery) -> {
		String topicName = delivery.getEnvelope().getExchange().replace('/', '.');
		String routingKey = delivery.getEnvelope().getRoutingKey();
		String message = new String(delivery.getBody(), "UTF-8");
		LOGGER.info("Message Arrives: \"" + message + " key:" + routingKey + " topic:" + topicName);
	};

	public void stop() {
		try {
			channel.close();
			connection.close();
		} catch (IOException | TimeoutException e) {
			LOGGER.error(e.getLocalizedMessage(), e);
		}
	}
	private static final Logger LOGGER = LogManager.getLogger(Amqp.class);

}
