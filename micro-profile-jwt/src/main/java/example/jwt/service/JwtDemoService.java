package example.jwt.service;

import java.security.Principal;
import java.util.Date;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.eclipse.microprofile.jwt.JsonWebToken;

import example.jwt.dto.StatusDTO;

@Path("rest")
public class JwtDemoService {

	@Inject
	private JsonWebToken token;
	
	@Inject
	Principal prins;

	@GET
	@Path("onlyDevRole")
	@RolesAllowed("dev")
	@Produces("application/json")
	public StatusDTO onlyDevRole() {
		StatusDTO st = new StatusDTO();
		st.setPrincipalName(prins.getName());
		st.setTokenIssurer(token.getIssuer());
		st.setTokenGroups(token.getGroups());
		st.setExpirationTime(new Date(token.getExpirationTime()));
	   return st;
	}    
}
