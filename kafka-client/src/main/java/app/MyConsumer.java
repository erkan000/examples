package app;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class MyConsumer {
	
	public static void main(String[] args) {
		MyConsumer m = new MyConsumer();		
		m.listenTopic("erkan");
	}

	private Consumer<Integer, String> createConsumer() {
		final Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:19092,localhost:29092,localhost:39092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "myGrup");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		return new KafkaConsumer<>(props);
	}
	
	public void listenTopic(String topic) {

		Consumer<Integer, String> consumer = createConsumer();

			consumer.subscribe(Collections.singleton(topic));
			ConsumerRecords<Integer, String> consumerRecords;
			while (true) {
				consumerRecords = consumer.poll(Duration.ofMillis(1000));
				if (consumerRecords.count() > 0) {
					for (ConsumerRecord<Integer, String> record : consumerRecords) {
						logger.info(record.key() + " - " + record.value());
					}
				}
				consumer.commitSync();
			}		
	}
	
	private final Logger logger = LogManager.getLogger(MyConsumer.class);

}