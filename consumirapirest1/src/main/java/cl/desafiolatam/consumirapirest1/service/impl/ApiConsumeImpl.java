package cl.desafiolatam.consumirapirest1.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cl.desafiolatam.consumirapirest1.response.Post;
import cl.desafiolatam.consumirapirest1.response.ResponseObject;
import cl.desafiolatam.consumirapirest1.service.ApiConsume;

public class ApiConsumeImpl implements ApiConsume {
	
	private static Client client;
	
	public ApiConsumeImpl() {
		super();
		client = ClientBuilder.newClient();
	}
	
	public List<Post> getPost(){
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts");
		
		Invocation.Builder invocationbuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationbuilder.get();
		
		List<Post> listaPost = response.readEntity(new GenericType<List<Post>>() {});
		
		System.out.println("GET: getPost Servicio Invocado correctamente : "+ response.getStatus());
		
		return listaPost;
	}
	public ResponseObject getPostResponseObject() {
		// TODO Auto-generated method stub
		ResponseObject responseObject = new ResponseObject();
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts");
		
		Invocation.Builder invocationbuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationbuilder.get();
		
		List<Post> listaPost = response.readEntity(new GenericType<List<Post>>() {});
		
		System.out.println("GET: getPost Servicio Invocado correctamente : "+ response.getStatus());
		responseObject.setBody(listaPost);
		responseObject.setStatus(response.getStatus());
		
		return responseObject;
	}

	public void setPost(Post post) {
		
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts");
		
		Invocation.Builder invocationbuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationbuilder.post(Entity.entity(post, MediaType.APPLICATION_JSON));
		
		Post po = response.readEntity(new GenericType<Post>() {});
		
		System.out.println("POST: setPost() Servicio Invocado correctamente : "+ response.getStatus() + " - "+po.toString());
		
	}

	public void updatePost(Post post, String id) {
		// TODO Auto-generated method stub
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts").path(id);
		
		Invocation.Builder invocationbuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationbuilder.put(Entity.entity(post, MediaType.APPLICATION_JSON));
		
		Post po = response.readEntity(new GenericType<Post>() {});
		
		System.out.println("PUT: updatePost() Servicio Invocado correctamente : "+ response.getStatus() + " - "+po.toString());
	}

	public void deletePost(String id) {
		// TODO Auto-generated method stub
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts").path(id);
		
		Invocation.Builder invocationbuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationbuilder.delete();
		
		Post po = response.readEntity(new GenericType<Post>() {});
		
		System.out.println("Delete: updatePost() Servicio Invocado correctamente : "+ response.getStatus() + " - "+po.toString());
	}

	public List<Post> getPostOne(String id) {
		// TODO Auto-generated method stub
		WebTarget target = client.target("https://jsonplaceholder.typicode.com").path("posts").path(id);
		
		Invocation.Builder invocationbuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationbuilder.get();
		
		Post post = response.readEntity(new GenericType<Post>() {}) ;
		
		List<Post> lisPostOne = new ArrayList<Post>();
		
		System.out.println("GET: getPostOne Servicio Invocado correctamente : "+ response.getStatus()+ " - "+post.toString());
		lisPostOne.add(post);
		
		return lisPostOne;
	}

	
	
	

}
