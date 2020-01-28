package examples.apachehttp.crawler;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import org.apache.http.client.ClientProtocolException;

public class JsfCrawler {

	public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, ClientProtocolException, IOException {
		ApacheHttpClient client = new ApacheHttpClient("https://www.github.com", true);
		System.out.println(client.getRequest("/"));
	}

}
