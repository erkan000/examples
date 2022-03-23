package chat.message.view;

import java.util.List;

import com.leftybeauty.schema.avro.AddressValue;
import com.leftybeauty.schema.avro.AppointmentSource;
import com.leftybeauty.schema.avro.AppointmentStatusEnum;
import com.leftybeauty.schema.avro.LeftyProviderServiceValue;
import com.leftybeauty.schema.avro.UsStateEnum;

import utils.GenericMessage;
import utils.ProducerUtil;

public class AppointmentSourceMessageProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<AppointmentSource> mesaj = 
				new GenericMessage<>("2", generateUserAvro());
		ProducerUtil.sendMessageToTopic("AppointmentSource" , mesaj);
	}
	
	private static AppointmentSource generateUserAvro() {
		AddressValue addressValue = AddressValue.newBuilder()
				.setAddressId("")
				.setStreet1("")
				.setCity("")
				.setState(UsStateEnum.Alabama)
				.setZipCode(0)
				.build();
		
		LeftyProviderServiceValue service = LeftyProviderServiceValue.newBuilder()
				.setLeftyProviderServiceId("")
				.setServiceCategoryName("")
				.setPrice(0)
				.build();
		
		return AppointmentSource
				.newBuilder()
				.setAppointmentId("a123")
				.setLeftyUserProviderId("a22")
				.setLeftyUserClientId("a444")
				.setClientAddress(addressValue)	
				.setAppointmentDateTime(0L)
				.setStatus(AppointmentStatusEnum.Proposed)
				.setLeftyProviderServices(List.of(service))
				.build();
	}

}
