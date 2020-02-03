package example.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsyncMessageListener implements MessageListener{

	private static final Logger logger = LoggerFactory.getLogger(AsyncMessageListener.class);
	private String consumerName;

	@Override
	public void onMessage(Message message) {
		TextMessage text = (TextMessage)message;
		try {
			logger.info(consumerName + " received: " + text.getText());
			System.out.println();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public AsyncMessageListener(String consumerName) {
		this.consumerName = consumerName;
	}

}
