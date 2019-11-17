package examples.prometheus;

import io.prometheus.client.Histogram;
import io.prometheus.client.exporter.MetricsServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class HistogramUsage {
	
		static class ExampleServlet extends HttpServlet {

		private static final long serialVersionUID = -4288519728794189389L;
		
		static final Histogram requestLatency = 
				Histogram
					.build()
					.name("requests_latency_seconds")
					.help("Request latency in seconds.")
					.register();

		@Override
		protected void doGet(final HttpServletRequest req, final HttpServletResponse resp){
			Histogram.Timer requestTimer = requestLatency.startTimer();
			try {
				resp.getWriter().println("This method measure latency.");
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