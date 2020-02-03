package example.queue;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
	private ActiveMQConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private MessageProducer messageProducer;

	public void create(String destinationName) throws JMSException {
		
		try{
			connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616", "admin", "erkan");
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(destinationName);
			messageProducer = session.createProducer(destination);
			connection.start();
		}catch (JMSException e) {
			e.printStackTrace();
		}		
		
	}

	public void close() {
		if (connectionFactory != null) {
			connectionFactory.close();
		}
		if (connection != null) {
			try { connection.close(); } catch (JMSException ex) { }
		}	
	}

	public void sendMessage(String message) throws JMSException{
		TextMessage textMessage = session.createTextMessage(message);
		messageProducer.send(textMessage);
		LOGGER.info("Message sent!");
	}

}
