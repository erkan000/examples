package example.queue;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
	private ActiveMQConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;
	private MessageConsumer messageConsumer;

	public void create(String destinationName) throws JMSException {
		
		try{
			connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616", "admin", "erkan");
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);				
			Destination destination = session.createQueue(destinationName);
			messageConsumer = session.createConsumer(destination);
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

	public String getMessage(int timeout) throws JMSException {
		String incoming = "";
		Message message = messageConsumer.receive(timeout);
		if (message != null) {
			TextMessage textMessage = (TextMessage) message;
			incoming = textMessage.getText();
			LOGGER.info("Received message:" + incoming);
		} else {
			LOGGER.info("Timeout occured while reading message.");
		}
		return incoming;
	}
	
	public void getMessageAsync() throws JMSException {
		messageConsumer.setMessageListener(new AsyncMessageListener("Consumer"));
	}

}
