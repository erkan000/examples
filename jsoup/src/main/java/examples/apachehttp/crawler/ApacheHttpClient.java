package examples.apachehttp.crawler;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.security.cert.X509Certificate;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;


public class ApacheHttpClient {
	
	private CloseableHttpClient httpclient;
	private BasicCookieStore cookieStore;
	private RequestConfig config;
	private String host;
	
	public String postRequest(String path, List<NameValuePair> paramList) throws ClientProtocolException, IOException{
		String result = null;
		HttpEntity parametreList = new UrlEncodedFormEntity(paramList);
		HttpPost httpPost = new HttpPost(host + path);
		httpPost.setConfig(config);
		httpPost.setEntity(parametreList);
		httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
		HttpClientContext localContext = HttpClientContext.create(); 
        localContext.setCookieStore(cookieStore);
        localContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
		CloseableHttpResponse response = httpclient.execute(httpPost, localContext);
		if(response.getStatusLine().getStatusCode() >= 200 && response.getStatusLine().getStatusCode() < 300)
			result = processResponse(response);
		response.close();
		return result;		
	}
	
	public String getRequest(String path) throws ClientProtocolException, IOException{
		String result = null;
		HttpGet httpGet = new HttpGet(host + path);
		httpGet.setConfig(config);
		HttpClientContext localContext = HttpClientContext.create(); 
        localContext.setCookieStore(cookieStore);
        localContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
		CloseableHttpResponse response = httpclient.execute(httpGet, localContext);
		if(response.getStatusLine().getStatusCode() >= 200 && response.getStatusLine().getStatusCode() < 300)
			result = processResponse(response);
		response.close();
		return result;
	}
	
	private String processResponse(CloseableHttpResponse response) throws UnsupportedOperationException, IOException{
		String result = null;
		HttpEntity entity = response.getEntity();
		if(entity != null)
			result  = IOUtils.toString(entity.getContent(), "UTF-8");
		EntityUtils.consume(entity);
		return result;		
	}
	
	public ApacheHttpClient(String host, boolean configSystemProxy) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
//		debugAc();
		cookieStore = new BasicCookieStore();
		configRequest();
		SSLConnectionSocketFactory sslConnectionSocketFactory = configSSL();
		this.host = host.trim();
		
		if(configSystemProxy){
			httpclient = HttpClients
					.custom()
					.setSSLSocketFactory(sslConnectionSocketFactory)
					//.setDefaultCredentialsProvider(credsProvider)
					//.useSystemProperties()
					.setDefaultCookieStore(cookieStore)
					.build();
		}else{
			httpclient = HttpClients
					.custom()
					.setSSLSocketFactory(sslConnectionSocketFactory)
					.setDefaultCredentialsProvider(configManualProxy())
					.useSystemProperties()
					.setDefaultCookieStore(cookieStore)
					.build();
		}
	}
	
	private void debugAc(){
		System.setProperty("javax.net.debug", "ssl,record,trustmanager");
		
		System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.SimpleLog");
    	System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
    	System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.wire", "DEBUG");
    	
    	System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.impl.conn", "DEBUG");
    	System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.impl.client", "DEBUG");
    	System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.client", "DEBUG");
    	System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "DEBUG");
	}
	
	private void configRequest(){
		config = RequestConfig.custom()
				//.setProxy(proxy)
				.setSocketTimeout(10000)
				.build();
	}
	
	private SSLConnectionSocketFactory configSSL() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException{
		// use the TrustSelfSignedStrategy to allow Self Signed Certificates
		SSLContext sslContext = SSLContextBuilder
				.create()
				//.loadTrustMaterial(new File("C:\\java_tmp\\ssl\\key.jks"), "changeit".toCharArray(),new TrustSelfSignedStrategy())
				.loadTrustMaterial(new TrustStrategy(){
					public boolean isTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
						// Burada bütün sertifikalara güveniliyor. Bunu sakın yapma, ne gelirse gelsin kabul eder!
						return true;
					}
				})
				.useProtocol("TLSv1.2")
				.build();

		// we can optionally disable hostname verification.
		HostnameVerifier allowAllHosts = new NoopHostnameVerifier();

		// create an SSL Socket Factory to use the SSLContext with the trust self signed certificate strategy and allow all hosts verifier.
		SSLConnectionSocketFactory connectionFactory = new SSLConnectionSocketFactory(
				sslContext,
				new String[]{"TLSv1.2"},   
				null,
				allowAllHosts);
		return connectionFactory;
	}
	
	private CredentialsProvider configManualProxy(){
		// proxy ayari elle de verebiliriz. httpclient oluştururken aşağıdaki satırı aç.
		//.setDefaultCredentialsProvider(credsProvider)
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				new AuthScope("proxy.x.intra", 80),
				new UsernamePasswordCredentials("user", "pass"));
		return credsProvider;
	}
	
    public String getViewState(String html) {
    	Document doc = Jsoup.parse(html);
        Elements doms = doc.select("[name=javax.faces.ViewState]");
        Element dom = doms.first();
        return dom.val();
    }

}
