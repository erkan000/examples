package jakarta.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("rest")
public class RestService {
	
	@GET
    @Path("/test")
    public Response getAllUsers() {
        return Response.ok("test ok").build();
    }
	
}
