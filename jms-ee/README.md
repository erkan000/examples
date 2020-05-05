### JMS (JSR 343)

This sample uses libery server maven plug-in, was embedded jms services, Message Driven EJB, CDI

- mvn clean package liberty:dev

Call this servlet for send messege to queue "myQueue" and it will consume by message driven bean, inspect the console.

- http://localhost:9080/jms-ee/sendMessageToMyQueue

Another sample is queue browser. Browser can inspect messages without consume them. Send a message using this servlet;

- http://localhost:9080/jms-ee/sendMessageToMyAnotherQueue

And you can inspect messages from this servlet;

- http://localhost:9080/jms-ee/browseMessages





