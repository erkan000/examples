package chat.message.view;

import java.util.UUID;

import com.leftybeauty.schema.avro.LeftyUserFeedbackSource;
import com.leftybeauty.schema.avro.LeftyUserTypeEnum;
import com.leftybeauty.schema.avro.RatingReasonEnum;

import utils.GenericMessage;
import utils.ProducerUtil;

public class LeftyUserFeedbackSourceProducer {
	
	public static void main(String[] args) throws Exception {
		LeftyUserFeedbackSource message = generateEmailSource("appoint-4");
		GenericMessage<LeftyUserFeedbackSource> mesaj = 
				new GenericMessage<>(message.getAppointmentId().toString(), message);
		ProducerUtil.sendMessageToTopic("LeftyUserFeedbackSource" , mesaj);
	}
	
	private static LeftyUserFeedbackSource generateEmailSource(String userId) {
		return LeftyUserFeedbackSource.newBuilder()
				.setAppointmentId(userId)
				.setComment("comm" + UUID.randomUUID().toString())
				.setFeedbackTarget(LeftyUserTypeEnum.Client)
				.setRating(123)
				.setReason(RatingReasonEnum.DidntListenToRequest)
				.build();
	}

}
