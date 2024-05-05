package jakarta.controllers;

import jakarta.beans.TaskService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/persons")
public class PersonController {

	@Inject
	TaskService service;

	@Path("")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response allPersons() {
		var data = service.doSomeJob("test");
		return Response.ok(data).build();
	}
}
