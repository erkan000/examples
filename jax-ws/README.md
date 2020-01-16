### JSR 224 Java API for XML Web Services samples
JSR 224 Java API for XML Web Services (JAX-WS) is a standardized API for creating and consuming SOAP (Simple Object Access Protocol) web services. 

#### Usage:
- Copy project
- mvn clean package
- mvn tomee:run
- http://localhost:8050/WebServiceServiceName?wsdl
- 


- You can specify web service using annotations or webservices.xml file. In this sample we used annotations but there is a sample webservices.xml file in WEB-INF folder.
- MTOM used for sending binary attachment data. 

@MTOM(enabled=true, threshold=2048)
@WebService

- Any binary data whose size, in bytes, exceeds the threshold value is XML-binary Optimized Packaging (XOP) encoded or sent as an attachment. When the message size is less than the threshold value, the message is inlined in the XML document as either base64 or hexBinary data. 