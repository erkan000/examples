package example.events;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class SessionListener implements HttpSessionActivationListener {

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		se.getSession().getServletContext().log("Listener : Session passive!");		
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		se.getSession().getServletContext().log("Listener : Session activated!");		
	}

}
