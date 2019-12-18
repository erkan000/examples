package microprofile.restclient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("restclient")
public class RestClientService {

	@Inject
    @RestClient
    private RestClientInterface restClient;
	
	@GET
    @Path("/listUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        return Response.ok(restClient.getUsers()).build();
    }
	
}
