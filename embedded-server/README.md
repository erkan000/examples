

#### Usage:
- Copy project
- mvn clean package
- mvn jetty:run
- http://localhost:8080/test
http://localhost:8080/hello



After packaging, directly use the command java -jar xxx.jar Just allow it


If the server is not up, the function of join() is to block the Thread. However, if your application is heavy, calling the join function can ensure that your server is really up (that is, before jetty start, the join method is blocked to avoid the exit of the JVM)

