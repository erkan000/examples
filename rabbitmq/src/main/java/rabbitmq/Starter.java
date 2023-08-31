package rabbitmq;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Starter {

	public static void main(String[] args) {
		Amqp amqp = new Amqp();
		amqp.initializeClient();
		amqp.registerAmqpMessageListener("erkanExchange", "erkanQueue");
		amqp.publishMessage("erkanExchange", "erkanQueue", "My super message", "erkan_routing_key");
		amqp.publishMessage("erkanExchange", "erkanQueue_2", "My super message_2", "erkan_routing_key_2");

		// for event loop
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				amqp.stop();
				System.exit(0);
			}

		});
	}

}
