package cl.desafiolatam.consumirapirest1.service;

import java.util.List;

import cl.desafiolatam.consumirapirest1.response.Post;
import cl.desafiolatam.consumirapirest1.response.ResponseObject;

public interface ApiConsume {

	public List<Post> getPost();
	public ResponseObject getPostResponseObject();
	//public List<> ResponseObject getPostResponseObject(String id);
	public List<Post> getPostOne(String id);
	public void setPost(Post post);
	public void updatePost(Post post, String id);
	public void deletePost(String id);	
}