package cl.desafiolatam.consumirapirest1.service;

import java.util.List;

import cl.desafiolatam.consumirapirest1.response.Post;

public interface ApiConsume {

	public List<Post> getPost();
	public List<Post> getPostOne(String id);
	public void setPost(Post post);
	public void updatePost(Post post, String id);
	public void deletePost(String id);	
}