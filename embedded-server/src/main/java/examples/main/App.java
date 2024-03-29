package examples.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import examples.servlet.HelloServlet;

public class App {

	public static void main(String[] args) throws Exception {
		  Server server = new Server(8080);

		  ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		  context.setContextPath("/");
		  server.setHandler(context);
		  
		  context.addServlet(new ServletHolder(new HelloServlet()), "/hello");
		  context.addServlet(new ServletHolder(new HelloServlet()), "/test");

		  server.start();
		  System.out.println("Server started!");
		  
		  server.join();
		}
	
}

