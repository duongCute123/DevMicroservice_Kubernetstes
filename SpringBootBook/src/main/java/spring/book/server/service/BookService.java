package spring.book.server.service;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
	public List<Book> findAllBool();

	public void saveBook(Book book);
}
