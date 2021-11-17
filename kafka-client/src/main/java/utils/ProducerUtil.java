package utils;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import java.util.Properties;

public class ProducerUtil {

	private static <T> Producer<String, T> createProducer() {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "kullanici");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
		props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
		props.put(ProducerConfig.ACKS_CONFIG, "all");
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		return new KafkaProducer<>(props);
	}

	public static <T> void sendMessageToTopic(String topic, GenericMessage<T> mesaj) throws Exception {
		try (Producer<String, T> producer = createProducer()){
			ProducerRecord<String, T> record = new ProducerRecord<>(topic, mesaj.getKey(), mesaj.get());
			RecordMetadata metadata = producer.send(record).get();
			logger.info("Record = " + record.key() + " -- " +  record.value());
			logger.info("Metadata = " + metadata.partition() + " -- "  + metadata.offset());
		} 
	}

	public static <T> void sendMessageToTopicAsync(String topic, GenericMessage<T> mesaj) throws Exception {
		try (Producer<String, T> producer = createProducer()){
			ProducerRecord<String, T> record = new ProducerRecord<>(topic, mesaj.getKey(), mesaj.get());
			
			producer.send(record, new Callback() {
				@Override
				public void onCompletion(RecordMetadata metadata, Exception e) {
					if (e == null) {
						logger.info("Record = " + record.key() + " -- " +  record.value());
						logger.info("Metadata = " + metadata.partition() + " -- "  + metadata.offset());
					} else {
						logger.error(e.getMessage());
					}
				}
			});
		} 

	}

	private static final Logger logger = LogManager.getLogger(ProducerUtil.class);

}


