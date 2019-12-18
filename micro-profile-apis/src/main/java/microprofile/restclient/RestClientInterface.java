package microprofile.restclient;

import javax.json.JsonArray;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "http://jsonplaceholder.typicode.com/")
public interface RestClientInterface {

    @GET
    @Path("/users")
    public JsonArray getUsers();
}
