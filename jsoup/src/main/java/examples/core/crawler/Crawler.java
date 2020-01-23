package examples.core.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
    
	public URL url;
    private static final String SET_COOKIE = "Set-Cookie";
    private static final String SET_COOKIE_SEPARATOR="; ";
    private static final String COOKIE = "Cookie";
    private static final char NAME_VALUE_SEPARATOR = '=';
    private static final String USER_AGENT = "User-Agent";
    private static final String USER_AGENT_VALUE = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2";
    private static CookieManager msCookieManager = new CookieManager();
    
    public Crawler(String endpoint) throws MalformedURLException{
    	url = new URL(endpoint);
    }
    
    public String getRequest(String path) throws IOException{
    	URL url = new URL(this.url.getProtocol() + "://" + this.url.getHost() + ":" + this.url.getPort() + path);
    	URLConnection con = url.openConnection();
    	con.setRequestProperty(USER_AGENT, USER_AGENT_VALUE);
    	setCookies(con);
    	con.connect();
    	getCookies(con);
    	return getPageContent(con);
    }

    private void getCookies(URLConnection connection){
    	Map<String, List<String>> headerFields = connection.getHeaderFields();
    	List<String> cookiesHeader = headerFields.get(SET_COOKIE);
    	if (cookiesHeader != null) {
    	    for (String cookie : cookiesHeader) {
    	        msCookieManager.getCookieStore().add(null, HttpCookie.parse(cookie).get(0));
    	    }               
    	}
    }

    private void setCookies(URLConnection connection){
    	if (msCookieManager.getCookieStore() != null && !msCookieManager.getCookieStore().getCookies().isEmpty()) {
    		String cookies = parseCookies();
    	    connection.setRequestProperty(COOKIE, cookies);    
    	}
    }

    public String showCookiews(){
        String cookiesAsString = "";
        if (msCookieManager.getCookieStore() != null && !msCookieManager.getCookieStore().getCookies().isEmpty()) {
    		cookiesAsString = parseCookies();
    	}        
        return cookiesAsString;
    }
    
    private String parseCookies() {
    	StringBuilder names = new StringBuilder();
		List<HttpCookie> cookies = msCookieManager.getCookieStore().getCookies();
		for (int i = 0; i < cookies.size(); i++) {
			HttpCookie cookie = cookies.get(i);
			names.append(cookie);
			if(cookies.size() != i+1) {
				names.append(SET_COOKIE_SEPARATOR);
			}
//			joining the Cookies, use ',' or ';' as needed. Most of the servers are using ';'
		}
		return names.toString();
    }

    public String getPageContent(URLConnection conn){
    	StringBuilder contents = new StringBuilder();
    	try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
    		String line;
    		while ((line = bufferedReader.readLine()) != null) {
    			contents.append(line);
    			contents.append(System.lineSeparator());
    		}
    	}catch (IOException e) {
    		System.out.println(e);
    	}
    	return contents.toString();
    }

    public String postRequest(String path, Map<String , String> parameters) throws IOException{    	
    	URL url = new URL(this.url.getProtocol() + "://" + this.url.getHost() + ":" + this.url.getPort() + path);
    	URLConnection con = url.openConnection();
    	con.setRequestProperty(USER_AGENT, USER_AGENT_VALUE);
    	setCookies(con);
    	con.setDoOutput(true);
//    	con.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
    	con.setRequestProperty( "charset", StandardCharsets.UTF_8.name());    	
    	
    	StringBuilder data = new StringBuilder();
    	Iterator<String> it = parameters.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            String value = parameters.get(key);
            data.append(key + NAME_VALUE_SEPARATOR + URLEncoder.encode(value, StandardCharsets.UTF_8.name()));
            if(it.hasNext()) {
            	data.append("&");
            }
        }
        con.setRequestProperty("Content-Length", String.valueOf(data.toString().getBytes().length));

        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        wr.write(data.toString());
        wr.flush();
        wr.close();
    	
    	con.connect();
    	getCookies(con);
    	return getPageContent(con);  	
    }
    
    public String getViewState(String html) {
    	Document doc = Jsoup.parse(html);
        Elements doms = doc.select("[name=javax.faces.ViewState]");
        Element dom = doms.first();
        return dom.val();
    }
    
}
