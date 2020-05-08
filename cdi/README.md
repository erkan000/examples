## CDI Contexts and Dependency Injection (JSR 346)

CDI samples

- example.basic.TestBasic class show basic @Inject usage. Also IdGenerator interface show @Qualifier usage.

- example.producer.TestProducer is producers samples. Produce and disposes file resource, produce logging implementation classes.

- example.event.TestEvent class shows Observer design pattern implementation on CDI

- example.interceptor.TestInterceptor class add an interceptor to createPerson method, and it only prints inception status.

### Dependency injection Design Patterns

- Bridge (with alternatives)

- Factory (with producers)

- Interceptor

- Decorator

- Observer/observable (with events)