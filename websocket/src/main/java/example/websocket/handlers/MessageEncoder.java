package example.websocket.handlers;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageEncoder implements Encoder.Text<Message>{
	
	@Override
	public String encode(Message object) throws EncodeException {
		String text ="";
		ObjectMapper mapper = new ObjectMapper();
		try {
			text = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			return "";
		}
		return text;
	}

	@Override
	public void init(EndpointConfig config) {
		
	}

	@Override
	public void destroy() {
		
	}

}
