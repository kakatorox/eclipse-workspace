package cl.desafiolatam.anchorbooks.service;

import java.util.List;

import cl.desafiolatam.anchorbooks.response.BookDetail;

public interface ApiConsumeBookDetail {
	public List<BookDetail> getBookDetail();
	public void getBookDetailAuthor(String author);
	public void getBookDetailDelivery(boolean delivery);
}
