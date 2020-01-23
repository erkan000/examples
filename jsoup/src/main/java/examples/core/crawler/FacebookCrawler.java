package examples.core.crawler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FacebookCrawler {

	public static void main(String[] args) throws IOException {

		Crawler c = new Crawler("https://m.facebook.com/");
		String response = c.getRequest("/");
		Map<String,String> parameters = getLoginParametersAndData(response);
		
		String url = getActionURL(response);

		System.out.println(c.postRequest(url, parameters));
		
	}
	
	private static Map<String,String> getLoginParametersAndData(String html) throws UnsupportedEncodingException{
		Map<String,String> parameters = new HashMap<>();
		Document doc = Jsoup.parse(html);
		Elements doms = doc.select("form");
		Element dom = doms.first();
		Elements inputs = dom.getElementsByTag("input");
		for(int i=0;i<inputs.size();i++){
			if(!inputs.get(i).attr("name").isEmpty())
				parameters.put(inputs.get(i).attr("name"),
						URLEncoder.encode(inputs.get(i).attr("value"), StandardCharsets.UTF_8.name()));
		}
        parameters.replace("email", URLEncoder.encode("tesst@hotmail.com", StandardCharsets.UTF_8.name()));
        parameters.replace("pass", URLEncoder.encode("Passw0rd", StandardCharsets.UTF_8.name()));
        parameters.replace("timezone", URLEncoder.encode("-120", StandardCharsets.UTF_8.name()));        
		return parameters;
	}
	
    private static String getActionURL(String html){
        Document doc = Jsoup.parse(html);
        Elements doms = doc.select("form");
        Element dom = doms.first();
        return dom.attr("action");
    }

}
