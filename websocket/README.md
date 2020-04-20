### Websockets

This sample demostrates the Java API for WebSocket (JSR 356)
 
TODO: Encoders and decoders can add to code



* http://localhost:8080/websocket
* http://localhost:8080/websocket/time.html

#### Test packages
* example.WebSocketTest class added to tests, it is a websocket client
* example.whatsApp.Gui class is to test whatsapp web websocket communication. It is only for messaging. Chat communication is AES-CBC encripted.
* to test login to wa web and from dev tools, get these variables from "Local storage";
 - WAToken1: client token
 - WAToken2: server token
 - (WASecretBundle)
	
* write them to params.txt and you are in. 
* can test "writing.." message with presence command. When someone write to you, you will receive "Precence" message with number!




