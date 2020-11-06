package example.servlet;

import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.redis.ConnectionPool;
import redis.clients.jedis.Jedis;

@WebServlet(urlPatterns="/publish")
public class RedisPublishServlet  extends HttpServlet implements javax.servlet.Servlet{


	private static final long serialVersionUID = 6701774619204694922L;
	private static Logger logger = LoggerFactory.getLogger(RedisPublishServlet.class);
	
	public RedisPublishServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ServletOutputStream outputStream = null;
		long start = System.currentTimeMillis();
		try (Jedis jedis = ConnectionPool.jedisPool.getResource()){
			outputStream = response.getOutputStream();
			outputStream.print("Mesaj gonderildi");
			outputStream.print("\r\n");
			outputStream.print("\r\n");
			jedis.publish("test", "Time is: " + start);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		long stop = System.currentTimeMillis();
		outputStream.print(stop - start + " milisaniyede tamamlandi.");
	}
}
