package app.schema.registy;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SchemaRegTest {
	
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		SchemaRegTest test = new SchemaRegTest();
		SchemaPojo u = test.parseAvro(test.readAvroFile("chatMessageSourceEvent.avsc"));
		for (int i = 0; i < u.getFields().length; i++) {
			String name = u.getFields()[i].getName();
			String type = u.getFields()[i].getType()[1];
			System.out.println(name + "--" + type);
		}
		
	}
	
	public SchemaPojo parseAvro(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, SchemaPojo.class);
	}
	
	public HttpResponse<String> sendSchemaToSchemaRegistry(String veri, String subjectName) throws URISyntaxException, IOException, InterruptedException{
		HttpClient client = HttpClient.newHttpClient();
		veri = veri.replace("\"", "\\\"");
		veri = veri.replace("\r", "");
		veri = veri.replace("\n", "");
		veri = veri.replace("\t", "");
		System.out.println("Data will be sent:" + veri);
		String aa = "{\"schema\": \"" + veri + "\"}";
		BodyPublisher bodyPublisher = BodyPublishers.ofString(aa);
		HttpRequest request = HttpRequest.newBuilder()
				.header("Content-Type", "application/vnd.schemaregistry.v1+json")
				  .uri(new URI("http://localhost:8081/subjects/" + subjectName + "-value/versions"))
				  .POST(bodyPublisher )
				  .build();
		return client.send(request, HttpResponse.BodyHandlers.ofString());
	}
	
	public String readAvroFile(String fileName) throws IOException {
		Path p = Path.of("src/main/resources/avro/" + fileName);
		return Files.readString(p);
	}
	
	public CreateTopicsResult createTopic() {
		Properties properties = new Properties();
		properties.put(
				AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092"
				);
		Admin admin = Admin.create(properties);
		Collection<NewTopic> newTopics = new ArrayList<NewTopic>();
		NewTopic topic = new NewTopic("testSubject", 1, (short)1);
		newTopics.add(topic);
		return admin.createTopics(newTopics);
	}

}
