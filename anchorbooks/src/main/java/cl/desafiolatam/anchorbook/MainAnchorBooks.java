package cl.desafiolatam.anchorbook;
import java.util.ArrayList;
import java.util.List;
import cl.desafiolatam.anchorbooks.response.Book;
import cl.desafiolatam.anchorbooks.response.BookDetail;
import cl.desafiolatam.anchorbooks.service.ApiConsumeBook;
import cl.desafiolatam.anchorbooks.service.ApiConsumeBookDetail;
import cl.desafiolatam.anchorbooks.service.impl.ApiConsumeBookImpl;
import cl.desafiolatam.anchorbooks.service.impl.ApiConsumeBookDetailImpl;
public class MainAnchorBooks {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Book> liBooks=new ArrayList<Book>();
		ApiConsumeBook apiServiceBook = new ApiConsumeBookImpl();
		liBooks = apiServiceBook.getBooks();
		 for (Book book : liBooks) { 
			 System.out.println(book);
			 }
		System.out.println("\n************************************");
		apiServiceBook.getBooksAuthorTitle();
		System.out.println("\n************************************");
		apiServiceBook.getBooksOne("3","8");
		System.out.println("\n************************************");
		List<BookDetail> liBookDetails= new ArrayList<BookDetail>();
		ApiConsumeBookDetail apiServiceBookDetail = new ApiConsumeBookDetailImpl();
		liBookDetails = apiServiceBookDetail.getBookDetail();
		for (BookDetail bookDetail : liBookDetails) {
			System.out.println(bookDetail);
		}
		System.out.println("\n************************************");
		apiServiceBookDetail.getBookDetailAuthor("Unknown");
		System.out.println("\n************************************");
		apiServiceBookDetail.getBookDetailDelivery(true);
	}

}