### Quarkus First Demo

From https://quarkus.io/ 
"A Kubernetes Native Java stack tailored for OpenJDK HotSpot and GraalVM, crafted from the best of breed Java libraries and standards."

This is a very basic Quarkus sample app

#### Usage:
- Copy project
- mvn clean compile
- mvn quarkus:dev
- Navigate to http://localhost:8080/
- Navigate to http://localhost:8080/quarkus

#### Notes
- With Quarkus, there is no need to create an Application class. It’s supported, but not required. In addition, only one instance of the resource is created and not one per request. You can configure this using the different *Scoped annotations (ApplicationScoped, RequestScoped, etc).