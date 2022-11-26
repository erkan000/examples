### Quarkus First Demo

From https://quarkus.io/ 
"A Kubernetes Native Java stack tailored for OpenJDK HotSpot and GraalVM, crafted from the best of breed Java libraries and standards."

This is a very basic Quarkus sample app

#### Usage:
- Copy project
- mvn clean compile
- mvn quarkus:dev (Read stopping server section)
- Navigate to http://localhost:8080/
- Navigate to http://localhost:8080/quarkus
- Web components frontend added, navigate to http://localhost:8080/demo.html

- mvn quarkus:list-extensions	Lists extensions(e.g quarkus-resteasy-jsonb)

#### Notes
- With Quarkus, there is no need to create an Application class. It’s supported, but not required. In addition, only one instance of the resource is created and not one per request. You can configure this using the different *Scoped annotations (ApplicationScoped, RequestScoped, etc).

#### Stopping server
 In documentation dev server can be stopped by "CTRL+C", but in Eclipse, shortcut doesn't works. (https://www.eclipse.org/forums/index.php/t/587605/)
 
 Solution is to use "@QuarkusMain" annotation, so you can start and stop quarkus like a spring boot project. Only run Main.java!, thats it.
 
 Json parsing is done by "quarkus-resteasy-jsonb" dependency.
 

### Web components
- MDN web docs 
 - https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement
 
- All web documents
 - https://devdocs.io/
 
- Browser sync
 - lit-html
 
 - Code pack
  - snowpack or rollup.js


