package example.servlet;

import java.io.IOException;
import java.security.SecureRandom;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/longPolling", asyncSupported=true)
public class LongPollingServlet3_0 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * THIS LONG WAITING RESPONSE DOESNT BLOCK SERVLET CONTAINER
	 * SO CONTAINER THREAT POOL DOESNT OCCUPIED
	 * 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final AsyncContext asyncCtx = request.startAsync();
        asyncCtx.start( new Runnable(){
            public void run()
            {
                ServletResponse response = asyncCtx.getResponse();
                try {
                	String wait = waitRandomSeconds();
                    response.getWriter().write(wait);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                asyncCtx.complete();
            }
        });
	}
	
	private static String waitRandomSeconds() {
		long start = System.currentTimeMillis();
		try {
			SecureRandom secureRandom = new SecureRandom();
			secureRandom.setSeed( System.currentTimeMillis() );
			long sleepTimeInMilli = 3000L + 500L*secureRandom.nextInt(10);
			Thread.sleep(sleepTimeInMilli);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		long end = System.currentTimeMillis();
		return (end-start)+ "ms passed.";
	}

}
