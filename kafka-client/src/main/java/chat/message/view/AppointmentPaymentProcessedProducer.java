package chat.message.view;

import com.leftybeauty.schema.avro.AppointmentPaymentProcessed;
import com.leftybeauty.schema.avro.LeftyPaymentStatusEnum;
import com.leftybeauty.schema.avro.LeftyPaymentTypeEnum;

import utils.GenericMessage;
import utils.ProducerUtil;

public class AppointmentPaymentProcessedProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<AppointmentPaymentProcessed> mesaj = 
				new GenericMessage<>("1", createAppointmentPaymentProcessedEvent("1234"));
		ProducerUtil.sendMessageToTopic("AppointmentPaymentProcessed" , mesaj);
	}
	
	private static AppointmentPaymentProcessed createAppointmentPaymentProcessedEvent(CharSequence identifier) {
		return AppointmentPaymentProcessed
				.newBuilder()
				.setAmount(12)
				.setAppointmentId("d")
				.setPaymentMethodId("dfds")
				.setProviderTransactionIdentifier(identifier)
				.setStatus(LeftyPaymentStatusEnum.Approved)
				.setTransactionType(LeftyPaymentTypeEnum.Refund)
				.build();
	}

}
