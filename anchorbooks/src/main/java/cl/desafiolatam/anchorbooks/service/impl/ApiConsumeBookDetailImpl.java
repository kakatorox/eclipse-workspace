package cl.desafiolatam.anchorbooks.service.impl;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import cl.desafiolatam.anchorbooks.response.BookDetail;
import cl.desafiolatam.anchorbooks.service.ApiConsumeBookDetail;

public class ApiConsumeBookDetailImpl implements ApiConsumeBookDetail{

	private static Client client;
	
	public ApiConsumeBookDetailImpl() {
		// TODO Auto-generated constructor stub
		super();
		client = ClientBuilder.newClient();
	}
	
	public List<BookDetail> getBookDetail() {
		// TODO Auto-generated method stub
		WebTarget target = client.target("https://my-json-server.typicode.com").path("Himuravidal").path("anchorBooks").path("bookDetail");

		Invocation.Builder invocationbuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationbuilder.get();
		
		List<BookDetail> listaBookDetail = response.readEntity(new GenericType<List<BookDetail>>() {});
				
		return listaBookDetail;
	}

	public void getBookDetailAuthor(String author) {
		// TODO Auto-generated method stub
		WebTarget target = client.target("https://my-json-server.typicode.com")
									.path("Himuravidal")
									.path("anchorBooks")
									.path("bookDetail")
									.queryParam("author",author);

		Invocation.Builder invocationbuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationbuilder.get();
		
		List<BookDetail> listaBookDetail = response.readEntity(new GenericType<List<BookDetail>>() {});
		
		System.out.println("Autores anónimos:");
		for (BookDetail bookDetail : listaBookDetail) {
				System.out.println("Autor: "+bookDetail.getAuthor()+" - libro:"+bookDetail.getTitle());
		}
	}

	public void getBookDetailDelivery(boolean delivery) {
		// TODO Auto-generated method stub
		WebTarget target = client.target("https://my-json-server.typicode.com")
								 	.path("Himuravidal")
								 	.path("anchorBooks")
								 	.path("bookDetail")
								 	.queryParam("delivery",delivery);

		Invocation.Builder invocationbuilder = target.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationbuilder.get();
		
		List<BookDetail> listaBookDetail = response.readEntity(new GenericType<List<BookDetail>>() {});
		
		System.out.println("Libros con delivery disponibles:\n");
		for (BookDetail bookDetail : listaBookDetail) {
				System.out.println("Libro: "+bookDetail.getTitle());
		}
		
		
	}
}