package microprofile.openapi;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("openapiservice")
public class OpenAPIService {
	
	@GET
	@Tag(name = "BETA", description = "This API is currently in beta state")
	@Operation(summary = "Get my car", description = "Returns my car informations")
	@APIResponse(responseCode = "404", description = "Not found my car")
	@APIResponse(responseCode = "500", description = "My car crashed!")
	@APIResponse(responseCode = "200", description = "OK")
	@APIResponse(description = "Car",
    		content = @Content(mediaType = "application/json",
    		schema = @Schema(implementation = Car.class)))
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getMyCar() {
	   Car car = new Car("BMW", "740i", LocalDate.now(), 10l, false, BigDecimal.valueOf(16.5), 12.5d);
	   return Response.ok(car).build();
	}
    
}
