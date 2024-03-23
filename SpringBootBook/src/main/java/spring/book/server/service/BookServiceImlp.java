package spring.book.server.service;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.book.server.reponsetory.BookReponsetory;

@Service
public class BookServiceImlp implements BookService {
	@Autowired
	BookReponsetory bookReponsetory;

	@Override
	public List<Book> findAllBool() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		
	}
}
