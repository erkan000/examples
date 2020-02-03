package example.topic;

import java.util.Properties;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopicConsumer {

	public void receiveMessage() {
		
		Context context = null;
		TopicConnectionFactory factory = null;
		TopicConnection connection = null;
		TopicSession session = null;
		Topic topic = null;
		TopicSubscriber subscriber = null;
		
		Properties initialProperties = new Properties();
		initialProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.artemis.jndi.ActiveMQInitialContextFactory");
		initialProperties.put(Context.PROVIDER_URL, "tcp://localhost:61616");

		try {
			context = new InitialContext();		// we use jndi lookup(look at jndi.properties file)
//			context = new InitialContext(initialProperties);

			topic = (Topic) context.lookup("topic/exampleTopic");

			factory = (TopicConnectionFactory) context.lookup("ConnectionFactory");

			connection = factory.createTopicConnection("admin","erkan");

			session = connection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);

			subscriber = session.createSubscriber(topic);
			connection.start();
			logger.info("Waiting for message...");
			
			Message message = subscriber.receive();
			if (message instanceof Message) {
				ActiveMQMessage object = ((ActiveMQMessage) message);
				logger.info("I have received : " +  object.getBody(String.class));
			}

		} catch (NamingException | JMSException e) {
			e.printStackTrace();
		} finally {
			if (context != null) {
				try { context.close(); } catch (NamingException ex) { }
			}
			if (connection != null) {
				try { connection.close(); } catch (JMSException ex) { }
			}
		}

	}

	public static void main(String[] args) {
		TopicConsumer client = new TopicConsumer();
		client.receiveMessage();
	}

	private static final Logger logger = LoggerFactory.getLogger(TopicConsumer.class);
}


