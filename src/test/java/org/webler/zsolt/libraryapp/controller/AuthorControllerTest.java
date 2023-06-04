package org.webler.zsolt.libraryapp.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import org.webler.zsolt.libraryapp.model.Author;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AuthorControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAuthors() {
        ResponseEntity<List> response = restTemplate.getForEntity("/author", List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void testAddAuthor() {
        Author author = new Author();
        author.setName("Dickens");
        author.setPhoneNumber("+12 34 567 8901");
        ResponseEntity<Author> response = restTemplate.postForEntity("/author", author, Author.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Author createdAuthor = response.getBody();
        assertNotNull(createdAuthor);
    }
}
