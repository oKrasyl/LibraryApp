package org.webler.zsolt.libraryapp.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.webler.zsolt.libraryapp.model.Book;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    LibrarianService service;
//
//    @Test
//    public void getAllBookEmptyTest() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(get("/book"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();
//
//        ObjectMapper mapper = new ObjectMapper();
//        Book[] books = mapper.readValue(mvcResult.getResponse().getContentAsString(), Book[].class);
//
//        assertThat(books.length == 0);
//        System.out.println();
//    }
//
//    @Test
//    public void getAllBookTest() throws Exception {
//
//        ObjectMapper mapper = new ObjectMapper();
//        String oneBookList = mapper.writeValueAsString(Arrays.asList(new Book()));
//
//        Mockito.when(service.getBooks()).thenReturn(Arrays.asList(new Book()));
//
//        MvcResult mvcResult = mockMvc.perform(get("/book"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(oneBookList))
//                .andReturn();
//
//        System.out.println();
//    }
//
//    @Test
//    public void createBookTest() throws Exception {
//
//        ObjectMapper mapper = new ObjectMapper();
//        String bookJson = mapper.writeValueAsString(new Book());
//
//        Mockito.when(service.addBook(any())).thenReturn(true);
//
//        MvcResult mvcResult = mockMvc.perform(post("/book")
//                        .content(bookJson)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isCreated())
//                .andExpect(content().json(bookJson))
//                .andReturn();
//
//    }

}
