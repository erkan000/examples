package example.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import example.redis.ConnectionPool;
import redis.clients.jedis.Jedis;

@WebServlet(urlPatterns="/readWriteData")
public class RedisDataTypesServlet  extends HttpServlet implements javax.servlet.Servlet{

	private static final long serialVersionUID = 6701774619204694922L;
	private static Logger logger = LoggerFactory.getLogger(RedisDataTypesServlet.class);
	
	public RedisDataTypesServlet() {
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
			
//			String read-write
			jedis.set("debugMode", "test");
			String resultString = jedis.get("debugMode");
			logger.info(resultString);

//			List
			jedis.lpush("myList", "111");
			jedis.lpush("myList", "555");//
			String lastItem = jedis.rpop("myList");  	// will pop 111 and assign
			long size = jedis.llen("myList");
			logger.info(lastItem);
			logger.info("List size:" + size);

//			Set
			jedis.sadd("mySet", "Erkan");
			jedis.sadd("mySet", "Hi");
			Set<String> words = jedis.smembers("mySet");
			logger.info(words.toString());
			boolean exists = jedis.sismember("mySet", "Hi");
			logger.info("Exists: " + exists);
			jedis.srem("mySet", "Hi");					// will remove items

//			Hash
			jedis.hset("users:user1", "name", "Erkan");	// creates a folder named users
			jedis.hset("users:user1", "age", "35");
			String name = jedis.hget("users:user1", "name");
			Map<String, String> entries = jedis.hgetAll("users:user1");
			Integer age = Integer.parseInt(entries.get("age"));
			logger.info(name + " " + age);
			jedis.hset("users:user2", "name", "Test");
			jedis.hset("users:user2", "age", "20");

			String replicationInfo = jedis.info("Replication");		// Redis cluster infos
			outputStream.println(replicationInfo);
			
			logger.info(jedis.info());
			logger.info(jedis.clientList());						// Redis client list			

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		long stop = System.currentTimeMillis();
		outputStream.print(stop - start + " milisaniyede tamamlandi.");
	}
}
