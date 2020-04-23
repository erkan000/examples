package example;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import example.whatsApp.WsClientEndpoint;

public class HandlersTest {
	
	public static void main(String[] args) {
        try {            
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            String uri = "ws://localhost:8080/websocket/message/join";
            System.out.println("Connecting to " + uri);            
            
            WsClientEndpoint endpoint = new WsClientEndpoint();
            Session session = container.connectToServer(endpoint, URI.create(uri));
            
            session.getBasicRemote().sendText("{\"name\":\"erkan\", \"number\":5}");
            
            System.out.println("Arrived: " + endpoint.waitForMessage(3));
            
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}


