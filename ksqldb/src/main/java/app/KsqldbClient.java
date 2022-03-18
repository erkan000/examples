package app;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

import io.confluent.ksql.api.client.Client;
import io.confluent.ksql.api.client.ClientOptions;
import io.confluent.ksql.api.client.StreamedQueryResult;
import reactor.core.publisher.Mono;

public class KsqldbClient {

	public static void main(String[] args) throws MalformedURLException {
		final URL endpoint = new URL("http://localhost:8088");

		final ClientOptions options = ClientOptions.create()
				.setHost(endpoint.getHost())
				.setPort(endpoint.getPort());

		Client client = Client.create(options);
		CompletableFuture<StreamedQueryResult> stream = client.streamQuery("SELECT * from PersonSourceTable emit changes;");
		//		Mono<StreamedQueryResult> aa = Mono.fromFuture(() -> stream);
		//		aa.subscribe(x -> System.err.println("--" + x.poll().getValue(1)));


		stream.thenAccept(streamedQueryResult -> {
			System.out.println("Query has started. Query ID: " + streamedQueryResult.queryID());
			RowSubscriber subscriber = new RowSubscriber();
			streamedQueryResult.subscribe(subscriber);
		}).exceptionally(e -> {
			System.out.println("Request failed: " + e);
			return null;
		});
	}

}

