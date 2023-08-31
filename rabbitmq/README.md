### RabbitMq
- RabbitMQ is the most widely deployed open source message broker.
- Spring projects such as Spring AMQP encapsulate RabbitMQ best practices to manage connections.

#### Simulate rabbitmq server

  rabbit:
    image: rabbitmq:3.8.12-management
    hostname: rabbitmq
    container_name: rabbitmq
    ports:
      - 5672:5672
      - 15672:15672

#### Usage:
- Copy project
- run Startter.java
- It will create exhange and topics automatically