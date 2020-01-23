package examples.core.crawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsfCrawler {

	public static void main(String[] args) throws IOException {

		Crawler c = new Crawler("https://www.test.com");
		String response = c.getRequest("/kurum/login.jsf");
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("j_id_9:userName", "");	// user
		parameters.put("j_id_9:j_id_j", "");	// pass
		parameters.put("j_id_9_SUBMIT", "1");
		parameters.put("j_id_9:btnLogin", "");
		parameters.put("j_id_9:j_id_m", "");
		parameters.put("javax.faces.ViewState", c.getViewState(response));

		c.postRequest("/kurum/login.jsf", parameters);
		
		System.out.println(c.getRequest("/kurum/pages/yontim/test.jsf"));
		
		c.getRequest("/kurum/Logout");
	}

}
