package example.whatsApp;

import java.awt.FlowLayout;
import java.net.URI;
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.websocket.ClientEndpointConfig;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import javax.websocket.ClientEndpointConfig.Builder;  

public class Gui {
	
	public static void main(String sxx[]) { 
		Session session = null;
		try {
			JTextArea textArea = new JTextArea(20, 40);
			
			String clientId = "Csdfsdfsdsw==";
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			String uri = "wss://web.whatsapp.com/ws";
			System.out.println("Connecting to " + uri);
			Builder configBuilder = ClientEndpointConfig.Builder.create();
			configBuilder.configurator(new HttpHeaderConfig());
			ClientEndpointConfig clientConfig = configBuilder.build();
			WsClientEndpoint endpoint = new WsClientEndpoint(textArea);
			session = container.connectToServer(endpoint, clientConfig, URI.create(uri));

			JFrame frame = new JFrame("Websocket");  
			frame.setVisible(true);
			JPanel panel = new JPanel();  
			panel.setLayout(new FlowLayout());
			
			JButton btnPing = new JButton();	
			btnPing.addActionListener(new GuiMessageSend(session, "--8,[\"admin\",\"test\"]"));
			btnPing.setText("Ping");
			panel.add(btnPing);
			
			JButton btnAlive = new JButton();	
			btnAlive.addActionListener(new GuiMessageSend(session, "?,,"));
			btnAlive.setText("Keep alive");
			panel.add(btnAlive);			
			
			JButton btnInit = new JButton(); 
			btnInit.addActionListener(new GuiMessageSend(session, ".--0,[\"admin\",\"init\",[2,2013,7],[\"Windows\",\"Firefox\",\"10\"],\"" + clientId + "\",true]"));
			btnInit.setText("Init");
			panel.add(btnInit);
			
			// messageTag,["admin","login","clientToken","serverToken","clientId","takeover"]
			JButton btnLogin = new JButton();	
			btnLogin.addActionListener(new GuiMessageSend(session, ".--1,[\"admin\",\"login\",\"" + WaParser.clientToken  +  "\",\"" + WaParser.serverToken  + "\", \"" + clientId  + "\" ,\"takeover\"]"));
			btnLogin.setText("Login");
			panel.add(btnLogin);		
			
			panel.add(textArea);
			frame.add(panel);  
			frame.setSize(500, 500);  
			frame.setLocationRelativeTo(null);  
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
			frame.addWindowListener(new GuiClose(session));
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}  
}  
