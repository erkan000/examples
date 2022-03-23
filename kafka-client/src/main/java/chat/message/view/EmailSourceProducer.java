package chat.message.view;

import com.leftybeauty.schema.avro.AddressSource;
import com.leftybeauty.schema.avro.EmailSource;
import com.leftybeauty.schema.avro.UsStateEnum;

import utils.GenericMessage;
import utils.ProducerUtil;

public class EmailSourceProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<EmailSource> mesaj = 
				new GenericMessage<>("userId5", generateEmailSource("userId5"));
		ProducerUtil.sendMessageToTopic("EmailSource" , mesaj);
	}
	
	private static EmailSource generateEmailSource(String userId) {
		return EmailSource.newBuilder()
				.setLeftyUserId(userId)
				.setAddress("adresim3")
				.build();
	}

}
