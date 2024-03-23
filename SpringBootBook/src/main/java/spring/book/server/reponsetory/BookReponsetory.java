package spring.book.server.reponsetory;



import org.springframework.data.jpa.repository.JpaRepository;

import spring.book.server.entity.Book;

public interface BookReponsetory extends JpaRepository<Book, Integer>  {

}
