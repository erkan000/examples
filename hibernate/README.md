### Hibernate Sample

This is a very basic Hibernate Sample. It uses in-memory H2 database.

#### Usage:
- Copy project
- mvn clean compile test-compile
- run tests from tests package and inspect the results

- IslemRepositoryImpl.java is implementation of Repository Pattern without Spring Data JPA or Apache DeltaSpike Data frameworks.

#### Notes:

- hbm2ddl.auto creates data structure based upon "hibernate.cfg.xml" file. But if you use schemas hbm2dll cant generate schemas! So you need to manually create any schema like this;

```java
jdbc:h2:mem:testDB;INIT=runscript from 'classpath:create.sql'
jdbc:h2:mem:testDB;INIT=create schema IF NOT EXISTS GSS
```

