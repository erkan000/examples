package example.whatsApp;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.websocket.Session;

public class GuiClose extends WindowAdapter {
	
	private Session session;
	
	public GuiClose(Session ses) {
		this.session = ses;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			session.close();
			System.exit(0);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
