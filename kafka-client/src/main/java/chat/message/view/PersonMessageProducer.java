package chat.message.view;

import com.leftybeauty.schema.avro.PersonSource;

import utils.GenericMessage;
import utils.ProducerUtil;

public class PersonMessageProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<PersonSource> mesaj = 
				new GenericMessage<>("provId5", generateChatSource("provId5"));
		ProducerUtil.sendMessageToTopic("PersonSource" , mesaj);
	}
	
	private static PersonSource generateChatSource(String userId) {
		return PersonSource.newBuilder()
				.setFirstName("erkan 2")
				.setLastName("deneme 2")
				.setLeftyUserId(userId)
				.build();
	}

}
