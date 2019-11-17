package examples.prometheus;

import io.prometheus.client.Summary;
import io.prometheus.client.exporter.MetricsServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class MeasureTime {

	static class ExampleServlet extends HttpServlet {

		private static final long serialVersionUID = -4288519728794189389L;

		static final Summary requestLatency = 
				Summary.build()
				.name("example_servlet_requests_latency_seconds")
				.help("Request latency in seconds.")
				.register();

		@Override
		protected void doGet(final HttpServletRequest req, final HttpServletResponse resp){
			Summary.Timer requestTimer = requestLatency.startTimer();
			try {
				resp.getWriter().println("This method waits 0.5 seconds.");
				Thread.sleep(500l);
			}catch (Exception e) {
			}
			requestTimer.observeDuration();
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