package chat.message.view;

import java.util.Arrays;

import com.leftybeauty.schema.avro.LeftyProviderServiceView;

import utils.GenericMessage;
import utils.ProducerUtil;

public class ProviderViewMessageProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<LeftyProviderServiceView> mesaj = 
				new GenericMessage<>("1", generateUserAvro("eee1"));
		ProducerUtil.sendMessageToTopic("LeftyProviderServiceView" , mesaj);
	}
	
	private static LeftyProviderServiceView generateUserAvro(String sss) {
		
		return LeftyProviderServiceView
				.newBuilder()
				.setLeftyProviderServiceId("1hk3")
				.setPrice(12.92)
				.setLeftyUserId("441")
				.setServiceName("ds")
				.setDescription("erkan")
				.setStorageProviderLocations(Arrays.asList(sss))
				.build();
	}

}
