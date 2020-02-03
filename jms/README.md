### JSR 343: Java Message Service 2.0
JMS Java Messaging Service API is a Java Message Oriented Middleware (MOM) API for sending messages between two or more clients. It enables asynchronous and reliable messaging.

To use JMS, we need to have a JMS provider that can manage the sessions, queues, and topics. Some JMS providers are Apache ActiveMQ, WebSphere MQ. Also Java EE compliant application servers has built-in JMS providers.

Messaging systems normally support two main styles of asynchronous messaging: message queue messaging (also known as point-to-point messaging) and publish subscribe messaging.

Messaging protocols
- Java Message Service (JMS)
- RESTful API
- STOMP
- AMQP
- OpenWire

#### Usage:
- On windows click build.bat


#### Artemis Usage:
- Download ActiveMQ Artemis zip from (https://activemq.apache.org/components/artemis/download/)
- Extract zip file, navigate /bin and type this command "artemis create mybroker --user admin --password admin --require-login Y" . It will create a directory named mybroker.
- Navigate to mybroker/bin and run "artemis run"
- if ports using change ports from /mybroker/etc/broker.xml file in the "<acceptor name" tags
- More info about ActiveMQ https://activemq.apache.org/components/artemis/documentation/latest/using-server.html