package example.jwt;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.apache.cxf.common.util.Base64Exception;
import org.junit.Before;
import org.junit.Test;

import ibm.utils.JwtVerifier;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.hamcrest.CoreMatchers.is;

public class JWTRequestIT {

	private static String endPoint = "http://localhost:9080/micro-profile-jwt/jwt/rest/onlyDevRole";
	private Client client;
	private WebTarget tut;
	
	@Before
	public void test() {
		this.client = ClientBuilder.newClient();
		this.tut = this.client.target(endPoint);
	}
	
	@Test
	public void testDevRole() throws Base64Exception, GeneralSecurityException, IOException {	
		Builder builder = this.tut.request();
		String jwt = new JwtVerifier().createDevJwt("erkan");
		builder.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt );
		Response response = builder.get();
		assertThat(response.getStatus(), is(200));
		System.out.println(response.readEntity(String.class));
		response.close(); 
	}
	
	@Test
	public void testUserRole() throws Base64Exception, GeneralSecurityException, IOException {	
		Builder builder = this.tut.request();
		String jwt = new JwtVerifier().createUserJwt("erkan");
		builder.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt );
		Response response = builder.get();
		assertThat(response.getStatus(), is(403));
		System.out.println(response.readEntity(String.class));
		response.close(); 
	}

}
