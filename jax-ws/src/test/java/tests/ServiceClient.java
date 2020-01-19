package tests;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import example.jaxws.Service;

public class ServiceClient {
	
	@Test
	public void testService() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(Service.class);
		
//		--- Set outgoing XML header ---
//		List<Handler> h = Arrays.asList((Handler) new WSSUsernameTokenSecurityHandler());
//		factory.setHandlers(h);
		
        factory.setAddress("http://localhost:8050/WebServiceServiceName");
        Service clientTransaction = (Service) factory.create();
        String cvp = clientTransaction.myFirstServiceMethod("Test string");
        Assert.assertThat(cvp, CoreMatchers.containsString("Test string"));
        
//    	--- Write incoming and outgoing XMLs ---
//      Client client = ClientProxy.getClient(clientTransaction);
//      client.getInInterceptors().add(new LoggingInInterceptor());
//      client.getOutInterceptors().add(new LoggingOutInterceptor());

//      --- Configure secure services for HTTPS ---
//      configureSecureTransaction(clientTransaction);
	}
	
//	public static void configureSecureTransaction(Class clientTransaction) {
//        Client client = ClientProxy.getClient(clientTransaction);
//        HTTPConduit http = (HTTPConduit) client.getConduit();
//        String targetAddress = http.getTarget().getAddress().getValue();
//        System.out.println("Received Address:" + targetAddress);
//
//        if (targetAddress.toLowerCase().startsWith("https:")) {
//        	System.out.println("ExecutetManager for  HTTPS");
//            TrustManager[] simpleTrustManager = new TrustManager[] { new X509TrustManager() {
//                public void checkClientTrusted(
//                        java.security.cert.X509Certificate[] certs, String authType) {
//                }
//                public void checkServerTrusted(
//                        java.security.cert.X509Certificate[] certs, String authType) {
//                }
//                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                    return null;
//                }
//            } };
//            TLSClientParameters tlsParams = new TLSClientParameters();
//            tlsParams.setTrustManagers(simpleTrustManager);
//            tlsParams.setDisableCNCheck(true);
//            http.setTlsClientParameters(tlsParams);
//        }
//    }

}
