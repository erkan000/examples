package example.jms;

import java.io.IOException;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/consumeMessage")
public class ConsumeFromMyQueueServlet extends HttpServlet{
	
	private static final long serialVersionUID = -2937565979540000489L;

	@Inject
	@JMSConnectionFactory("jms/myQueueConnectionFactory")
	JMSContext context;
	
	@Resource(lookup = "jms/myQueue")
	private Queue queue;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		// wait for message till timeout
		try (JMSConsumer consumer = context.createConsumer(queue)){
			Message message = consumer.receive(10000);
			if(message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				resp.getWriter().write("Consumed message is : " + textMessage.getText());
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
