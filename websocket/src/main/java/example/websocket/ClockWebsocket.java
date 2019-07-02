package example.websocket;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/clock")
public class ClockWebsocket {
    
    static ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor(); 
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
//    private static Set<Session> peers2 = Collections.newSetFromMap(new ConcurrentHashMap<Session, Boolean>());
    
    @OnOpen
    public void onOpen(Session session) {
        if (session.getOpenSessions().size()==1){   
             timer.scheduleAtFixedRate(new Runnable() {
                 @Override
                 public void run() {
                     broadcast(session);
                 }
             },0,1,TimeUnit.SECONDS);    

      }
        peers.add(session);
    }
    
    @OnClose
    public void onClose(Session session) {
        peers.remove(session);
    }

    public void broadcast(Session session) {
        for (Iterator<Session> it = peers.iterator(); it.hasNext();) {
            try {
                Session peer = it.next();
                peer.getBasicRemote().sendText("Time: " +
                        LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            } catch (IOException ex) {
                // ex
            }
        }
    }
}
