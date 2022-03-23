package chat.message.view;

import avro.User;
import utils.GenericMessage;
import utils.ProducerUtil;

public class UserMessageProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<User> mesaj = 
				new GenericMessage<>("1", generateUserAvro("123"));
		ProducerUtil.sendMessageToTopic("ChatMessageSource" , mesaj);
	}
	
	private static User generateUserAvro(String userId) {
		return User.newBuilder()
				.setUserId(userId)
				.setFirstName("Erkan")
				.setLastName("S")
				.build();
	}

}
