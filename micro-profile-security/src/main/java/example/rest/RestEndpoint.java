package example.rest;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("")
public class RestEndpoint {
	
	@Inject
    private CustomSecurityService service;

    @GET
    @RolesAllowed("admin")
    @Path("admin")
    public String ping() {
        return "Admin roles can view this!";
    }
    
    @GET
    @RolesAllowed("user")
    @Path("user")
    public String getUser() {
        return "User roles can view this!";
    }
    
    @Path("me")
    @GET
    public String customSecurityService() {
        return service.validateUser();
    }
}
