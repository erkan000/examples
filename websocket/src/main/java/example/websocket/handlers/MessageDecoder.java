package example.websocket.handlers;

import java.io.IOException;
import java.io.StringReader;

import javax.json.Json;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageDecoder implements Decoder.Text<Message>{

	@Override
	public boolean willDecode(String s) {
		try {
			Json.createReader(new StringReader(s));
			return true;
		}catch (Exception e) {
			return false;
		}		
	}
	
	@Override
	public Message decode(String s) throws DecodeException {
		Message object = null;
		if(willDecode(s)) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				object = mapper.readValue(s, Message.class);
			} catch (IOException e) {
				object = null;
			}
		}
		return object;
	}
	
	@Override
	public void init(EndpointConfig config) {		
	}

	@Override
	public void destroy() {		
	}

}
