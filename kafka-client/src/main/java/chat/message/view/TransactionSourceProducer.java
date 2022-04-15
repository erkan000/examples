package chat.message.view;

import com.leftybeauty.schema.avro.LeftyTransactionTypeEnum;
import com.leftybeauty.schema.avro.TransactionSource;

import utils.GenericMessage;
import utils.ProducerUtil;

public class TransactionSourceProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<TransactionSource> mesaj = 
				new GenericMessage<>("clientTransaction5", generateTransactionSource("1234"));
		ProducerUtil.sendMessageToTopic("TransactionSource" , mesaj);
	}
	
	private static TransactionSource generateTransactionSource(String providerTransactionIdentifier) {
		return TransactionSource
				.newBuilder()
				.setProviderTransactionIdentifier(providerTransactionIdentifier)
				.setAmount(13.7)
				.setTransactionId("transactionTestId")
				.setType(LeftyTransactionTypeEnum.Refund)
				.setPaymentMethodId("payMethodId")
				.build();		
		
	}

}
