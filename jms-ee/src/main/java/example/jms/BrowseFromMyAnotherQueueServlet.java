package example.jms;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.TextMessage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/browseMessages")
public class BrowseFromMyAnotherQueueServlet extends HttpServlet{
	
	private static final long serialVersionUID = 8092564786628868446L;

	@Inject
	@JMSConnectionFactory("jms/myQueueConnectionFactory")
	JMSContext context;
	
	@Resource(lookup = "jms/myAnotherQueue")
	private Queue queue;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		StringBuilder messages = new StringBuilder("Messages:" + System.lineSeparator());
		try(QueueBrowser queueBrowser = context.createBrowser(queue)){
			Enumeration enumeration = queueBrowser.getEnumeration();
			int count = 0;
			while (enumeration.hasMoreElements()) {
				Message message = (Message)enumeration.nextElement();
				if (message instanceof TextMessage) {
					messages.append("Message: " + ((TextMessage) message).getText() + System.lineSeparator());
				}
				count++;
			}
			messages.append(queue.getQueueName() + " queue has " + count + " messages!");
			resp.getWriter().write(messages.toString());
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	
}
