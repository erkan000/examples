package chat.message.view;

import com.leftybeauty.schema.avro.ChatMessageSource;
import com.leftybeauty.schema.avro.MessageActorEnum;

import utils.GenericMessage;
import utils.ProducerUtil;

public class ChatMessageProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<ChatMessageSource> mesaj = 
				new GenericMessage<>("5", generateChatSource(MessageActorEnum.Provider));
		ProducerUtil.sendMessageToTopic("ChatMessageSource" , mesaj);
	}
	
	private static ChatMessageSource generateChatSource(MessageActorEnum actor) {
		return ChatMessageSource.newBuilder()
				.setAppointmentId("447")
				.setMessage("test15")
				.setTimestamp(15L)
				.setActor(actor)
				.build();
	}

}
