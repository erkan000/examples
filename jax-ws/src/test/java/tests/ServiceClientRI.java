package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import tests.header.WSSUsernameTokenSecurityHandler;

public class ServiceClientRI {
	
	private static final String WS_URL = "http://localhost:8050/WebServiceServiceName?wsdl";
	
	private static final WSSUsernameTokenSecurityHandler wSSUsernameTokenSecurityHandler = new WSSUsernameTokenSecurityHandler();

	@Test
	public void serviceClient() throws MalformedURLException {
		headerYazdir();
		
		URL url = new URL(WS_URL);
        QName qname = new QName("http://target.namespace.com.tr", "WebServiceServiceName");
        //headerYazdir();
        Service service = Service.create(url, qname);
        HandlerResolver handlerResolver = new HandlerResolver() {
			
			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {				
				 List<Handler> handlerList = new ArrayList<Handler>();
	             handlerList.add(wSSUsernameTokenSecurityHandler);
	             return handlerList;
			}
			
		};
		service.setHandlerResolver(handlerResolver);   		
		        
		example.jaxws.Service servisIslemleri = service.getPort(example.jaxws.Service.class);        

        Map<String, Object> req_ctx = ((BindingProvider)servisIslemleri).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

		//BU KISIM HTTP REQUEST HEADER'DAKI USER'I SET EDİYOR.
        /*******************UserName & Password ******************************
        Map<String, Object> req_ctx = ((BindingProvider)hello).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList(""));
        headers.put("Password", Collections.singletonList(""));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        /**********************************************************************/
        

        String cvp = servisIslemleri.myFirstServiceMethod("Test erkan");
        Assert.assertThat(cvp, CoreMatchers.containsString("Test erkan"));
	
	}
	
	private void headerYazdir(){
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
	}
	
}
