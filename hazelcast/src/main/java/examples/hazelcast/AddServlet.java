package examples.hazelcast;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hazelcast.core.Hazelcast;

@WebServlet(value="/add")
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, Integer> map = Hazelcast.getHazelcastInstanceByName("devHz").getMap("data");
		Integer count = 0;
		if(map.containsKey("count")){
			count = map.get("count");
			count++;
			map.put("count", count);
		}else{
			map.put("count", 1);
			count = 1;
		}
		response.getWriter().write("Hazelcast map count key value is : " + count);

	}	

}
