package chat.message.view;

import java.util.List;

import com.leftybeauty.schema.avro.AppointmentProposed;
import utils.GenericMessage;
import utils.ProducerUtil;

public class AppointmentProposedMessageProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<AppointmentProposed> mesaj = 
				new GenericMessage<>("1", createAppointmentProposedEvent());
		ProducerUtil.sendMessageToTopic("AppointmentProposed" , mesaj);
	}
	
	private static AppointmentProposed createAppointmentProposedEvent() {
		return AppointmentProposed
				.newBuilder()
				.setLeftyUserProviderId("666")
				.setClientAddressId("")
				.setAppointmentDateTime(0L)
				.setProposedTimestamp(0l)
				.setLeftyProviderServiceIds(List.of("a"))
				.build();
	}

}
