package chat.message.view;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.Uuid;
import org.apache.kafka.common.serialization.StringSerializer;

import com.leftybeauty.schema.avro.ServiceCategorySource;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import utils.GenericMessage;
import utils.ProducerUtil;

public class ServiceCategorySourceProducer {
	
	public static void main(String[] args) throws Exception {
		GenericMessage<ServiceCategorySource> mesaj = 
				new GenericMessage<>("3", generateUserAvro());
		sendMessageToTopic("ServiceCategorySource2" , mesaj);
	}
	
	private static ServiceCategorySource generateUserAvro() {
		return ServiceCategorySource.newBuilder()
				.setName(Uuid.randomUuid().toString())
				.setParentId("Parent")
				.setServiceCategoryId("7")
				.build();
	}
	
	
	public static <T> void sendMessageToTopic(String topic, GenericMessage<T> mesaj) throws Exception {
		try (Producer<T, T> producer = createProducer()){
			ProducerRecord<T, T> record = new ProducerRecord<>(topic, mesaj.get(), mesaj.get());
			RecordMetadata metadata = producer.send(record).get();
			System.out.println("Record = " + record.key() + " -- " +  record.value());
			System.out.println("Metadata = " + metadata.partition() + " -- "  + metadata.offset());
		} 
	}

	
	private static <T> Producer<T, T> createProducer() {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "test");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
		props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
		props.put(ProducerConfig.ACKS_CONFIG, "all");
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		return new KafkaProducer<>(props);
	}
	
}
