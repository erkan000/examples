package example.whatsApp;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextArea;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

public class WsClientEndpoint extends Endpoint{
	
	// to prevent race condition, made it volatile
	public volatile CountDownLatch messageLatch = new CountDownLatch(1);
	public String messageI = "";
	public JTextArea textArea = null;
	
    public WsClientEndpoint() {
	}
    
    public WsClientEndpoint(JTextArea textArea) {
		this.textArea = textArea;
	}

	@OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        System.out.println("CLIENT: Connected to endpoint: " + session.getBasicRemote());        
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String message) {
            	System.out.println(message);
            	messageI = message;
            	if(textArea != null)
            		textArea.append(message + "\r\n");
            	WaParser.parseLoginIds(message);
            	messageLatch.countDown();
            }
        });
    }

    @OnMessage
    public void processMessage(String message) {
        System.out.println("CLIENT: Received message: " + message);
        messageLatch.countDown();
    }
    
    public String waitForMessage(long second) throws InterruptedException {
    	if(messageLatch.getCount() > 0) {
    		messageLatch.await(second, TimeUnit.SECONDS);
        	messageLatch = new CountDownLatch(1);
    	}
    	return messageI;
    }

    @OnError
    public void processError(Throwable t) {
        t.printStackTrace();
    }
    
    @OnClose
    public void closed() {
        System.out.println("CLIENT closed");
    }    
    
}
