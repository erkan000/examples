package example.jaxws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService(targetNamespace="http://target.namespace.com.tr")
public interface Service{

	@WebMethod(action = "webMethodAction", operationName="webMethodOperationName" )
	@WebResult(name="webResultName")
	public String myFirstServiceMethod(@WebParam(name = "nameField") String name);
	
}
