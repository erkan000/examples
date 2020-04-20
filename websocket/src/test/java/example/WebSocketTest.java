package example;

import java.net.URI;
import javax.websocket.ClientEndpointConfig;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import javax.websocket.ClientEndpointConfig.Builder;

import example.whatsApp.HttpHeaderConfig;
import example.whatsApp.WsClientEndpoint;

public class WebSocketTest {
	
	public static void main(String[] args) {
        try {            
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            String uri = "ws://localhost:8080/websocket/socketEndpoint";
            System.out.println("Connecting to " + uri);
            
            // for setting HTTP headers
            Builder configBuilder = ClientEndpointConfig.Builder.create();
            configBuilder.configurator(new HttpHeaderConfig());
            ClientEndpointConfig clientConfig = configBuilder.build();
            
            WsClientEndpoint endpoint = new WsClientEndpoint();
            Session session = container.connectToServer(endpoint, clientConfig, URI.create(uri));
            
            session.getBasicRemote().sendText(" hello! ");
            
            endpoint.waitForMessage(3);
            
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}


