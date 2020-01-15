package beanvalidation.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import example.service.Person;

public class BeanValidation {
	
	private static String endPoint = "http://localhost:9090/micro-profile-beanvalidation/bean-validation/rest/test";
	private Client client;
	private WebTarget tut;
	
	@Before
	public void init() {
		this.client = ClientBuilder.newClient();
		this.tut = this.client.target(endPoint);
	}
	
	@Test
	public void wrongReq1() {	
		Builder builder = this.tut.request();		
		Person person = new Person();
		person.setAge(12);
		Jsonb jsonb = JsonbBuilder.create();
		String resultJson = jsonb.toJson(person);		
		Response response = builder.post(Entity.entity(resultJson, MediaType.APPLICATION_JSON), Response.class);
		assertThat(response.getStatus(), is(400));
		System.out.println(response.readEntity(String.class));
		response.close(); 
	}
	
	@Test
	public void wrongReq2() {	
		Builder builder = this.tut.request();		
		Person person = new Person();
		person.setAge(12);
		person.setName("dd");
		person.setValid(true);
		person.setSerialNumber("12");
		Jsonb jsonb = JsonbBuilder.create();
		String resultJson = jsonb.toJson(person);		
		Response response = builder.post(Entity.entity(resultJson, MediaType.APPLICATION_JSON), Response.class);
		assertThat(response.getStatus(), is(400));
		System.out.println(response.readEntity(String.class));
		response.close(); 
	}
	
	@Test
	public void succesfull() {	
		Builder builder = this.tut.request();		
		Person person = new Person();
		person.setAge(12);
		person.setName("dd");
		person.setValid(true);
		person.setSerialNumber("12");
		person.setLicenceNumber("1_5t");
		Jsonb jsonb = JsonbBuilder.create();
		String resultJson = jsonb.toJson(person);		
		Response response = builder.post(Entity.entity(resultJson, MediaType.APPLICATION_JSON), Response.class);
		assertThat(response.getStatus(), is(200));
		System.out.println(response.readEntity(String.class));
		response.close(); 
	}
	
	@After
	public void close() {
		this.client.close();
	}
	
}
