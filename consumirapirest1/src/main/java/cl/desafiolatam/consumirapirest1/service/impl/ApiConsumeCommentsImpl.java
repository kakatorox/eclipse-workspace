package cl.desafiolatam.consumirapirest1.service.impl;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cl.desafiolatam.consumirapirest1.response.Comments;
import cl.desafiolatam.consumirapirest1.service.ApiConsumeComments;

public class ApiConsumeCommentsImpl implements ApiConsumeComments {

	private static Client client;
	
	public ApiConsumeCommentsImpl() {
		// TODO Auto-generated constructor stub
		super();
		client = ClientBuilder.newClient();
	}
	
	public List<Comments> getComments() {
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("comments");
		
		Invocation.Builder invocationbuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationbuilder.get();
		
		List<Comments> listaComments = response.readEntity(new GenericType<List<Comments>>() {});
		
		System.out.println("GET: getComments Servicio Invocado correctamente : "+ response.getStatus());
		
		return listaComments;
	}

}
