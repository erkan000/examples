package example.whatsApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.websocket.EncodeException;
import javax.websocket.Session;

public class GuiMessageSend implements ActionListener{
	
		private Session session;
		private String message;
	
		public GuiMessageSend(Session session, String message) {
			this.session = session;
			this.message = message;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				long time = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
				String timeStr = "";
				if(!message.equals("?,,")) {
					timeStr = time + "";
				}
				session.getBasicRemote().sendObject(timeStr + message);
				
			} catch (IOException | EncodeException e1) {
				e1.printStackTrace();
			}
		}
	

}
