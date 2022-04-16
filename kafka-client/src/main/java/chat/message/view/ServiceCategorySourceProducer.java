package chat.message.view;

import org.apache.kafka.common.Uuid;

import com.leftybeauty.schema.avro.ServiceCategorySource;

import utils.GenericMessage;
import utils.ProducerUtil;

public class ServiceCategorySourceProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<ServiceCategorySource> mesaj = 
				new GenericMessage<>("3", generateUserAvro());
		ProducerUtil.sendMessageToTopic("ServiceCategorySource" , mesaj);
	}
	
	private static ServiceCategorySource generateUserAvro() {
		return ServiceCategorySource.newBuilder()
				.setName(Uuid.randomUuid().toString())
				.setParentId("Parent555")
				.setServiceCategoryId("5")
				.build();
	}
	
	
}
