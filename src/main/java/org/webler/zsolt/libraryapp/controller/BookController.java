package org.webler.zsolt.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.webler.zsolt.libraryapp.model.Book;
import org.webler.zsolt.libraryapp.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookRepository repository;

    @GetMapping
    public List<Book> getBooks() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        Optional<Book> BookById = repository.findById(id);
        if (BookById.isPresent()) {
            return BookById.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book Book) {
        return repository.save(Book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBookById(@PathVariable Long id, @RequestBody Book Book) {
        Optional<Book> bookById = repository.findById(id);
        if (bookById.isPresent()) {

            Book persistedBook = bookById.get();
            persistedBook.setIsbn(Book.getIsbn());
            persistedBook.setGenre(Book.getGenre());
            persistedBook.setTitle(Book.getTitle());
            persistedBook.setAvailable(Book.isAvailable());

            return repository.save(persistedBook);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
