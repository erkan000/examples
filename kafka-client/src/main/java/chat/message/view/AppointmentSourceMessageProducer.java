package chat.message.view;

import java.util.Arrays;
import java.util.List;

import com.leftybeauty.schema.avro.AddressValue;
import com.leftybeauty.schema.avro.AppointmentSource;
import com.leftybeauty.schema.avro.AppointmentStatusEnum;
import com.leftybeauty.schema.avro.FeeTypeEnum;
import com.leftybeauty.schema.avro.FeeValue;
import com.leftybeauty.schema.avro.LeftyProviderServiceValue;
import com.leftybeauty.schema.avro.SplitValue;
import com.leftybeauty.schema.avro.UsStateEnum;

import utils.GenericMessage;
import utils.ProducerUtil;

public class AppointmentSourceMessageProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<AppointmentSource> mesaj = 
				new GenericMessage<>("appoint-3", generateUserAvro());
		ProducerUtil.sendMessageToTopic("AppointmentSource" , mesaj);
	}
	
	private static AppointmentSource generateUserAvro() {
		AddressValue addressValue = AddressValue.newBuilder()
				.setAddressId("add-id")
				.setStreet1("st1")
				.setStreet2("str8")
				.setCity("anka")
				.setState(UsStateEnum.Alabama)
				.setZipCode(12)
				.build();
		
		LeftyProviderServiceValue service = LeftyProviderServiceValue.newBuilder()
				.setLeftyProviderServiceId("")
				.setServiceCategoryName("")
				.setPrice(0)
				.setDuration(3)
				.build();
		
		FeeValue value = FeeValue.newBuilder()
				.setAmount(12)
				.setFeeType(FeeTypeEnum.FlatAmount)
				.build();
		
		
		
		SplitValue splitValue = SplitValue.newBuilder()
				.setPaymentProviderAccountIdentifier("prov")
				.setPercentage(8)
				.build();
		
		return AppointmentSource
				.newBuilder()
				.setAppointmentId("appoint-0")
				.setLeftyUserProviderId("provider-1")
				.setLeftyUserClientId("client-1")
				.setClientAddress(addressValue)	
				.setAppointmentDateTime(0L)
				.setStatus(AppointmentStatusEnum.ClientProposed)
				.setLeftyProviderServices(List.of(service))
				.setFees(value )
				.setTransactionIds(Arrays.asList("test1"))
				.setPaymentMethodId("pay-1")
				.setTax(99)
				.setSplit(splitValue )
				.build();
	}

}
