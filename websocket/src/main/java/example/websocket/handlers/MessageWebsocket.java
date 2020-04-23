package example.websocket.handlers;

import java.io.IOException;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/message/{type}", 
				decoders = MessageDecoder.class,
				encoders = MessageEncoder.class)
public class MessageWebsocket {
    
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
    }
    
    @OnClose
    public void onClose(Session session) {
        session = null;
    }

    @OnMessage
    public void incomingMessage(Message message,@PathParam("type") String type) throws IOException, EncodeException {
        System.out.println("SERVER: " + type + " type Message Received: " + message);
        try {
			session.getBasicRemote().sendObject(message);
		} catch (IOException | EncodeException e) {
			session = null;
		}
    }
    
    
    
    @OnError
    public void processError(Throwable t) {
        t.printStackTrace();
    }
}
