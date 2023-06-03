package org.webler.zsolt.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.webler.zsolt.libraryapp.model.Author;
import org.webler.zsolt.libraryapp.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorRepository repository;

    @GetMapping
    public List<Author> getAuthors() {
        return repository.findAll();
    }

    @GetMapping("/name/{name}")
    public List<Author> getAuthorsByName(@PathVariable String name) {
        return repository.findAllAuthorByName(name);
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        Optional<Author> AuthorById = repository.findById(id);
        if (AuthorById.isPresent()) {
            return AuthorById.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author Author) {
        return repository.save(Author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthorById(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Author updateAuthorById(@PathVariable Long id, @RequestBody Author Author) {
        Optional<Author> AuthorById = repository.findById(id);
        if (AuthorById.isPresent()) {

            Author persistedAuthor = AuthorById.get();
            persistedAuthor.setName(Author.getName());

            return repository.save(persistedAuthor);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


}
