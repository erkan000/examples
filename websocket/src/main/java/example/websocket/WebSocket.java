package example.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/socketEndpoint")
public class WebSocket {
    
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
//    private static Set<Session> peers2 = Collections.newSetFromMap(new ConcurrentHashMap<Session, Boolean>());
    
    @OnOpen
    public void onOpen(Session session) {
        peers.add(session);
    }
    
    @OnClose
    public void onClose(Session session) {
        peers.remove(session);
    }

    @OnMessage
    public void incomingMessage(String text , Session session) throws IOException, EncodeException {
        System.out.println("Message Received: " + text);
        for (Session peer : peers) {
           // if (!peer.equals(session)) {
                peer.getBasicRemote().sendObject("You sent:" + text);
           // }
        }
    }
}
