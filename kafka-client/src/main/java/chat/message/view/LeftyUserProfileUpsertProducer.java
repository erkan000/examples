package chat.message.view;

import com.leftybeauty.schema.avro.LeftyUserProfileUpsert;
import com.leftybeauty.schema.avro.LeftyUserTypeEnum;

import utils.GenericMessage;
import utils.ProducerUtil;

public class LeftyUserProfileUpsertProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<LeftyUserProfileUpsert> mesaj = 
				new GenericMessage<>("userId4", generateEmailSource("userId4"));
		ProducerUtil.sendMessageToTopic("LeftyUserProfileUpsert" , mesaj);
	}
	
	private static LeftyUserProfileUpsert generateEmailSource(String userId) {
		return LeftyUserProfileUpsert.newBuilder()
				.setLeftyUserId(userId)
				.setCountryCode(1)
				.setExperience("ss")
				.setFirstName("ss")
				.setLastName("dd")
				.setPhoneNumber(1)
				.setUserType(LeftyUserTypeEnum.Client)
				.build();
	}

}
