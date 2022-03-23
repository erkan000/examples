package chat.message.view;

import com.leftybeauty.schema.avro.ChatMessageView;
import com.leftybeauty.schema.avro.MessageActorEnum;
import com.leftybeauty.schema.avro.PersonViewValue;

import utils.GenericMessage;
import utils.ProducerUtil;

public class ChatMessageViewEventProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<ChatMessageView> mesaj = 
				new GenericMessage<>("appointmentId-1", generateChatSource(MessageActorEnum.Provider));
		ProducerUtil.sendMessageToTopic("ChatMessageView", mesaj);
	}
	
	private static ChatMessageView generateChatSource(MessageActorEnum actor) {
		PersonViewValue person = PersonViewValue
				.newBuilder()
				.setAvatarUrl("avUrl")
				.setFirstName("erk")
				.setLastName("ne")
				.setLeftyUserId("userID")
				.setType(actor)
				.build();
		return ChatMessageView.newBuilder()
				.setAppointmentId("447")
				.setMessage("test29")
				.setTimestamp(29L)
				.setPerson(person )
				.build();
	}

}
