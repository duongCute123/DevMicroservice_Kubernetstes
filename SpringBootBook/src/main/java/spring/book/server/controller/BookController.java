package spring.book.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.book.server.entity.Book;
import spring.book.server.reponsetory.BookReponsetory;
import spring.book.server.service.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookController {
	@Autowired
	BookReponsetory bookReponsetory;
	@Autowired
	BookService bookService;

	@GetMapping("/book")
	public List<Book> getAllBook() {
		List<Book> books = new ArrayList<>();
		books = bookReponsetory.findAll();
		return books;
	}

	@PostMapping("/book")
	public String saveBook(@RequestBody Book book) {
		bookReponsetory.save(book);
		return "Them thanh cong nhe";
	}
}
