package examples.prometheus;

import io.prometheus.client.Counter;
import io.prometheus.client.exporter.MetricsServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JavaSimple {
	
	static class ExampleServlet extends HttpServlet {

		private static final long serialVersionUID = -4288519728794189389L;
		
		static final Counter requests = 
				Counter
				.build()
				.name("example_servlet_total")
				.help("Number of Example servlets served.").register();

		@Override
		protected void doGet(final HttpServletRequest req, final HttpServletResponse resp){
			try {
				resp.getWriter().println("This method counts how many times requested.");
			}catch (Exception e) {
			}			
			// Increment the number of requests.
			requests.inc();
		}
	}

	public static void main( String[] args ) throws Exception {
		Server server = new Server(1234);
		ServletContextHandler context = new ServletContextHandler();
		context.setContextPath("/");
		server.setHandler(context);
		context.addServlet(new ServletHolder(new ExampleServlet()), "/");
		context.addServlet(new ServletHolder(new MetricsServlet()), "/metrics");
		
		// Add default metrics about OS
		// DefaultExports.initialize();

		server.start();
		server.join();
	}
	
}