package example.topic;


import java.util.Properties;
import java.util.Random;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopicProducer {

	public void sendMessage(){
		Properties initialProperties = new Properties();
		initialProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.artemis.jndi.ActiveMQInitialContextFactory");
		initialProperties.put(Context.PROVIDER_URL, "tcp://localhost:61616");

		Connection connection = null;
		Context initialContext = null;
		try {
			// /Step 1. Create an initial context to perform the JNDI lookup.(jndi.properties file)
			initialContext = new InitialContext();

			// Step 2. perform a lookup on the topic
			Topic topic = (Topic) initialContext.lookup("topic/exampleTopic");

			// Step 3. perform a lookup on the Connection Factory
			ConnectionFactory cf = (ConnectionFactory) initialContext.lookup("ConnectionFactory");

			// Step 4. Create a JMS Connection
			connection = cf.createConnection("admin","erkan");

			// Step 5. Create a JMS Session
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Step 6. Create a Message Producer
			MessageProducer producer = session.createProducer(topic);

			// Step 9. Create a Text Message
			TextMessage message = session.createTextMessage("Number is: " + new Random().nextInt(1000));

			// Step 10. Send the Message
			producer.send(message);

			// Step 11. Start the Connection
			connection.start();

			logger.info("Message sent!");
		} catch (NamingException | JMSException e) {
			e.printStackTrace();
		} finally {
			if (initialContext != null) {
				try { initialContext.close(); } catch (NamingException ex) { }
			}
			if (connection != null) {
				try { connection.close(); } catch (JMSException ex) { }
			}
		}
	}

	public static void main(String[] args) {
		TopicProducer client = new TopicProducer();
		client.sendMessage();
	}

	private static final Logger logger = LoggerFactory.getLogger(TopicProducer.class);

}
