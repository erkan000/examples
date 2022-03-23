package chat.message.view;

import com.leftybeauty.schema.avro.AddressSource;
import com.leftybeauty.schema.avro.UsStateEnum;

import utils.GenericMessage;
import utils.ProducerUtil;

public class AddressSourceProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<AddressSource> mesaj = 
				new GenericMessage<>("clientAddress5", generateAddressSource("userId9"));
		ProducerUtil.sendMessageToTopic("AddressSource" , mesaj);
	}
	
	private static AddressSource generateAddressSource(String userId) {
		return AddressSource.newBuilder()
				.setLeftyUserId(userId)
				.setAddressId("clientAddress5")
				.setStreet1("str1")
				.setCity("Istanbul")
				.setState(UsStateEnum.Arizona)
				.setZipCode(123)
				.build();
	}

}
