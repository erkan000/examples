package chat.message.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.leftybeauty.schema.avro.AppointmentSource;
import com.leftybeauty.schema.avro.AppointmentStatusEnum;
import com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt;
import com.leftybeauty.schema.avro.LeftyProviderServiceSourceReferenceAt;
import com.leftybeauty.schema.avro.LeftyUserTypeEnum;
import utils.GenericMessage;
import utils.ProducerUtil;

public class AppointmentMessageProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<AppointmentSource> mesaj = 
				new GenericMessage<>("447", generateAppSource(LeftyUserTypeEnum.Provider));
		ProducerUtil.sendMessageToTopic("AppointmentSource" , mesaj);
	}
	
	private static AppointmentSource generateAppSource(LeftyUserTypeEnum actor) {
		FinancialAccountSourceReferenceAt referenceAt = new FinancialAccountSourceReferenceAt("we",123L);
		LeftyProviderServiceSourceReferenceAt referenceAt2 = new LeftyProviderServiceSourceReferenceAt("qs",456L);
		List<LeftyProviderServiceSourceReferenceAt> list = new ArrayList<>();
		list.add(referenceAt2);
		list.add(referenceAt2);
		return AppointmentSource.newBuilder()
				.setAppointmentId("447")
				.setActor(actor)
				.setStatus(AppointmentStatusEnum.InProgress)
				.setLeftyUserProviderId("provId5")
				.setLeftyProviderServiceReferences(list)				
				.setFinancialAccountReference(referenceAt)
				.setClientAddressId("clientAddress5")
				.setTransactionIds(Arrays.asList("e","r"))
				.setAppointmentDateTime(new Date().getTime())
				.build();
	}
    
}
