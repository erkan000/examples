### Servlet Sample App

This is a very basic Servlet demo app

#### Usage:
- Copy project
- mvn clean package
- mvn jetty:run
- goto http://localhost:8080/servlet3/


- Samples
    * http://localhost:8080/servlet3/fetchAPI.xhtml
    * http://localhost:8080/servlet3/generic?id=
    * http://localhost:8080/servlet3/sendPost.jsp
    * http://localhost:8080/servlet3/longPolling
    * http://localhost:8080/servlet3/async


### Secure a Servlet

```
@WebServlet("services/aaa")
@ServletSecurity(
@HttpConstraint(transportGuarantee = TransportGuarantee.CONFIDENTIAL,
    rolesAllowed = {"select"} ) 
		)
```

