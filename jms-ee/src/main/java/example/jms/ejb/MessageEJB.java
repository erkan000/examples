package example.jms.ejb;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "MessageMDB")
public class MessageEJB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("Received by Message Driven Bean : " + ((TextMessage) message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
