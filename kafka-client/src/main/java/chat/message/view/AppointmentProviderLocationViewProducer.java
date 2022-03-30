package chat.message.view;

import com.leftybeauty.schema.avro.AppointmentProviderLocationView;

import utils.GenericMessage;
import utils.ProducerUtil;

public class AppointmentProviderLocationViewProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<AppointmentProviderLocationView> mesaj = 
				new GenericMessage<>("1", createAppointmentProposedEvent());
		ProducerUtil.sendMessageToTopic("AppointmentProviderLocationView" , mesaj);
	}
	
	private static AppointmentProviderLocationView createAppointmentProposedEvent() {
		return AppointmentProviderLocationView
				.newBuilder()
				.setAppointmentId("appooo")
				.setFirstName("erkan")
				.setLastName("sar")
				.setLatitude(123)
				.setLongitude(999)
				.build();
	}

}
