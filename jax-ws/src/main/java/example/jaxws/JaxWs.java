package example.jaxws;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

//@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
//Jax-ws has 4 different styles (RPC Vs Document Style)
@WebService(name="WebServiceName", targetNamespace="http://target.namespace.com.tr", 
			serviceName="WebServiceServiceName", portName="WebServicePortName")
public class JaxWs{

	@WebMethod(action = "webMethodAction", operationName="webMethodOperationName" )
	@WebResult(name="webResultName")
	public String myFirstServiceMethod(@WebParam(name = "nameField") String name) {
		return "Your parameter is " + name + ". Your ip is: " + getRemoteAddr();
	}
	
	@Resource
	private WebServiceContext wsContext;
	@WebMethod(exclude = true)
	public String getRemoteAddr(){
		MessageContext mc = wsContext.getMessageContext();
		HttpServletRequest request = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);

		String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("PROXY-CLIENT-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = request.getHeader("WL-PROXY-CLIENT-IP"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = request.getHeader("HTTP_CLIENT_IP"); 
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
			ip = request.getRemoteAddr(); 
		}
		return ip;
	}

}
