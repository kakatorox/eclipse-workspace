package cl.desafiolatam.anchorbooks.service;

import java.util.List;

import cl.desafiolatam.anchorbooks.response.Book;
public interface ApiConsumeBook {

	public List<Book> getBooks();
	public void getBooksAuthorTitle();
	public void getBooksOne(String... id);	
}
