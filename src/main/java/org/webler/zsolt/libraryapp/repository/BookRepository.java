package org.webler.zsolt.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.webler.zsolt.libraryapp.model.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {


    Optional<Book> findBookByIsbn(String isbn);

    List<Book> findBookByTitle(String title);

    List<Book> findBookByGenre(String genre);

    List<Book> findBookByTitleIgnoreCaseStartsWith(String prefix);

    @Query("SELECT b FROM Book as b where b.available = true")
    List<Book> findAllAvailableBooks();

    @Query("SELECT b FROM Book as b where b.available = false")
    List<Book> findAllUnAvailableBooks();

    List<Book> findBookByAuthorName(String authorName);


}
