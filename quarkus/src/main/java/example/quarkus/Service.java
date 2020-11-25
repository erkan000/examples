package example.quarkus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/quarkus")
public class Service {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Hello from Quarkus!";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("json")
    public Person json() {
        return new Person("Erkan", 35);
    }
    
}