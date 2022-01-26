package cl.desafiolatam.consumirapirest1;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.consumirapirest1.response.Comments;
import cl.desafiolatam.consumirapirest1.response.Post;
import cl.desafiolatam.consumirapirest1.service.ApiConsume;
import cl.desafiolatam.consumirapirest1.service.ApiConsumeComments;
import cl.desafiolatam.consumirapirest1.service.impl.ApiConsumeCommentsImpl;
import cl.desafiolatam.consumirapirest1.service.impl.ApiConsumeImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Post> listaPost =new ArrayList<Post>();
		ApiConsume apiService = new ApiConsumeImpl();
		apiService.getPost();
		
		Post post= new Post();
		post.setUserId(1);
		post.setId(100);
		post.setTitle("Titulo prueba");
		post.setBody("Postprueba");
		
		apiService.setPost(post);
		
		
		post.setTitle("Hola Mundo 2");
		apiService.updatePost(post,"1");
		apiService.deletePost("101");
		listaPost = apiService.getPostOne("1");
		
		for (Post posta: listaPost) {
			System.out.println(posta);
		}
		
		
		ApiConsumeComments apiServiceComments = new ApiConsumeCommentsImpl();
		
		List<Comments> listCo = apiServiceComments.getComments();
		for (Comments comments : listCo) {
			
			System.out.println(comments);
		}
		
		
	}

}
