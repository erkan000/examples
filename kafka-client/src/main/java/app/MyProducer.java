package app;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.Properties;

public class MyProducer {

	public static void main(String[] args) throws Exception {
		MyProducer myProducer = new MyProducer();
		String message = "MESAJIM";
		myProducer.sendMessageToTopic("erkan" , message);
	}

	private Producer<Integer, String> createProducer() {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:19092,localhost:29092,localhost:39092");
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "kullanici");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.ACKS_CONFIG, "all");
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		//   SECURITY SETTINGS
		//        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
		//        props.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
		//        props.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username='user' password='pass';");
		return new KafkaProducer<>(props);
	}

	public void sendMessageToTopic(String topic, String message) throws Exception {

		Producer<Integer, String> producer = createProducer();

		try {
			ProducerRecord<Integer, String> record = new ProducerRecord<>(topic, LocalTime.now().getMinute(), message);
			RecordMetadata metadata = producer.send(record).get();
			logger.info("Record = " + record.key() + " -- " +  record.value());
			logger.info("Metadata = " + metadata.partition() + " -- "  + metadata.offset());
		} finally {
			producer.flush();
			producer.close();
		}
	}

	public void sendMessageToTopicAsync(String topic, String message) throws Exception {

		Producer<Integer, String> producer = createProducer();

		try {
			ProducerRecord<Integer, String> record = new ProducerRecord<>(topic, 12345, message);

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
		} finally {
			producer.flush();
			producer.close();
		}
	}

	private final Logger logger = LogManager.getLogger(MyProducer.class);

}
