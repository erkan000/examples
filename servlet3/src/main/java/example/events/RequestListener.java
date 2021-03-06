package example.events;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		sre.getServletContext().log("Listener : Request gone!");		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		sre.getServletContext().log("Listener : Request init!");		
	}

}
