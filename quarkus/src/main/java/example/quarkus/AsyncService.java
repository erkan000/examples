package example.quarkus;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/quarkusAsync")
public class AsyncService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public CompletionStage<String> hello() {
	    return CompletableFuture.supplyAsync(() -> {
	        return "Hello(Async) from Quarkus!";
	    });
	}
	
}