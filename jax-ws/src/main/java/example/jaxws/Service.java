package example.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace="http://target.namespace.com.tr")
public interface Service{

	@WebMethod(action = "webMethodAction", operationName="webMethodOperationName" )
	@WebResult(name="webResultName")
	public String myFirstServiceMethod(@WebParam(name = "nameField") String name);
	
}
