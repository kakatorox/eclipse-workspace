package cl.desafiolatam.anchorbooks.service.impl;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cl.desafiolatam.anchorbooks.response.Book;
import cl.desafiolatam.anchorbooks.service.ApiConsumeBook;

public class ApiConsumeBookImpl implements ApiConsumeBook {

	private static Client client;
	
	public ApiConsumeBookImpl() {
		// TODO Auto-generated constructor stub
		super();
		client = ClientBuilder.newClient();
	}
	
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		WebTarget target = client.target("https://my-json-server.typicode.com").path("Himuravidal").path("anchorBooks").path("books");
		
		Invocation.Builder invocationbuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationbuilder.get();
		
		List<Book> listaBook = response.readEntity(new GenericType<List<Book>>() {});
		
		System.out.println("GET: getBook Servicio Invocado correctamente : "+ response.getStatus());
		
		return listaBook;
	}
	public void getBooksAuthorTitle() {
		// TODO Auto-generated method stub
		WebTarget target = client.target("https://my-json-server.typicode.com").path("Himuravidal").path("anchorBooks").path("books");
		
		Invocation.Builder invocationbuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationbuilder.get();
		
		List<Book> listaBook = response.readEntity(new GenericType<List<Book>>() {});
				
		for (Book book : listaBook) {	
			StringBuilder stringBook = new StringBuilder();
			stringBook.append(book.getAuthor());
			stringBook.append(": ");
			stringBook.append(book.getTitle());
			stringBook.toString();
			System.out.println(stringBook);
		}		
	}
	
	public void getBooksOne(String... id) {
		WebTarget target = client.target("https://my-json-server.typicode.com")
									.path("Himuravidal")
									.path("anchorBooks")
									.path("books")
									.queryParam("id", id);
		Invocation.Builder invocationbuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationbuilder.get();
		
		List<Book> listaBook = response.readEntity(new GenericType<List<Book>>() {});
		for (Book book : listaBook) {
			System.out.println("Libro número"+book.getId()+": "+book.getAuthor()+", "+book.getTitle()+", "+book.getCountry());
		}			
	}
}
