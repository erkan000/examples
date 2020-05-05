package example.jms;

import java.io.IOException;
import java.time.LocalTime;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendMessageToMyAnotherQueue")
public class SendToMyAnotherQueueServlet extends HttpServlet{
	
	private static final long serialVersionUID = -3371322048196895470L;

	@Inject
	@JMSConnectionFactory("jms/myQueueConnectionFactory")
	JMSContext context;
	
	@Resource(lookup = "jms/myAnotherQueue")
	private Queue queue;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		JMSProducer producer = context.createProducer();
		String message = "This message sent from servlet " + LocalTime.now();
		producer.send(queue, message);
		resp.getWriter().write(message);
	}
	
}
