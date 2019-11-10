### Micro Profile API Samples

This is a very basic Micro Profile API Sample. It uses Open Liberty dev mode for development. Dev mode docs(https://github.com/OpenLiberty/ci.maven/tree/master/docs)

#### Usage:
- Copy project
- mvn clean package
- mvn liberty:dev
- mpConfig-1.3		http://localhost:9080/micro-profile-apis/api/config
- mpHealth-2.0		http://localhost:9080/health/
- mpOpenAPI-1.1		http://localhost:9080/openapi/