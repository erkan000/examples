### Hazelcast Sample

This is a very basic Hazelcast Sample. Hazelcast is an IMDG(in-memory data grid), which is a set of networked/clustered computers that pool together their random access memory (RAM) to let applications share data structures with other applications running in the cluster.

#### Usage:
- Copy project
- mvn clean verify
- mvn jetty:run
- Navigate to http://localhost:8080/hazelcast/add 
- When you refresh the page, servlet will get value from hazelcast instance and will increase by 1. Deploy this war to another JVM and you will see the value from previous JVM and changes on this JVM will affect another one.



