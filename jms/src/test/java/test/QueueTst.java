package test;

import static org.junit.Assert.assertEquals;
import javax.jms.JMSException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import example.queue.Consumer;
import example.queue.Producer;

public class QueueTst {

	private static Producer producer;
	private static Consumer consumer;

	@BeforeClass
	public static void setUpBeforeClass() throws JMSException {
		producer = new Producer();
		producer.create("test.q");
		consumer = new Consumer();
		consumer.create("test.q");
	}

	@Test
	public void amessageTest() {
		try {
			producer.sendMessage("erkan");
			String message = consumer.getMessage(1000);
			assertEquals("erkan", message);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAsync() {
		try {
			consumer.getMessageAsync();
			producer.sendMessage("erkan");
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws JMSException {
		producer.close();
		consumer.close();
	}

}
