### Micro Profile API Samples

This is a very basic Micro Profile API Sample. It uses Open Liberty dev mode for development. Dev mode docs(https://github.com/OpenLiberty/ci.maven/tree/master/docs)

#### Usage:
- Copy project
- mvn clean package
- mvn liberty:dev
- mpConfig-1.3		http://localhost:9080/micro-profile-apis/api/config
- mpHealth-2.0		http://localhost:9080/health/
- mpOpenAPI-1.1		http://localhost:9080/openapi/
- mpMetrics-2.0		http://localhost:9080/metrics/application/countedMethod
	Test methods for metrics;
- http://localhost:9080/micro-profile-apis/api/metrics/counted
- http://localhost:9080/micro-profile-apis/api/metrics/metered
- http://localhost:9080/micro-profile-apis/api/metrics/timed
 You can see metrics in more user friendly by prometheus(prometheus.io) Download package and set target app in "prometheus.yml" file. Thats it.
	