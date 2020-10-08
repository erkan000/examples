### Arquillian (https://arquillian.org/invasion/)

Arquillian is an innovative and highly extensible testing platform for the JVM that enables developers to easily create automated integration, functional and acceptance tests for Java middleware.

Arquillian brings the test to the runtime so you don’t have to manage the runtime from the test (or the build). Arquillian eliminates this burden by covering all aspects of test execution, which entails:

- Managing the lifecycle of the container (or containers)
- Bundling the test case, dependent classes and resources into a ShrinkWrap archive (or archives)
- Deploying the archive (or archives) to the container (or containers)
- Enriching the test case by providing dependency injection and other declarative services
- Executing the tests inside (or against) the container
- Capturing the results and returning them to the test runner for reporting


#### Usage
- mvn test

You will see that CDI annotations will work like they are in container. ContainerTest junit class will create ShrinkWrap archive file, archive content will print to console.