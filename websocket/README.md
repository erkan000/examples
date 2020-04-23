### Websockets (JSR 356)

This sample demostrates the Java API for WebSocket (JSR 356)

Messages can received in two way, 
- for string you can use MessageHandler.Whole
- for binary message you can use MessageHandler.Partial for receive data part by part.
Also you can specify them async

* http://localhost:8080/websocket
* http://localhost:8080/websocket/time.html

#### Test packages
* example.WebSocketTest class added to tests, it is a websocket client
* example.HandlersTest class added to tests, for encode,decode sample json messages
* example.whatsApp.Gui class is to test whatsapp web websocket communication. It is only for messaging. Chat communication is AES-CBC encripted.
* to test login to wa web and from dev tools, get these variables from "Local storage";
 - WAToken1: client token
 - WAToken2: server token
 - (WASecretBundle)
	
* write them to params.txt and you are in. 
* can test "writing.." message with presence command. When someone write to you, you will receive "Precence" message with number!

** Protocol details is here: https://github.com/sigalor/whatsapp-web-reveng/blob/master/README.md




