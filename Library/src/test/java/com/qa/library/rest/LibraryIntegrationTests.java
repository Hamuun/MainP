package com.qa.library.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.qa.library.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //cus other port in use
@AutoConfigureMockMvc // sets up the MockMVC object
@Sql(scripts = { "classpath:book-schema.sql", 
		"classpath:book-date.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class LibraryIntegrationTests {
	@Autowired // injects the mockmvc
	private MockMvc mvc; //object for sending mock http request
	@Autowired
	private ObjectMapper mapper;
	@Test
	void  testCreate() throws Exception {
		final Librarian testBook = new Librarian(null, "Harry Potter", 300, "JK Rowling", 5);
		String testBooksAsJSON = this.mapper.writeValueAsString(testBook);
		
		final Librarian savedBook = new Librarian(1, "Harry Potter", 300, "JK Rowling", 5);
		String savedBookAsJSON = this.mapper.writeValueAsString(savedBook);
		
		//to make a request like postman, need method, path, header and body
		RequestBuilder request = post("/createBook").contentType(MediaType.APPLICATION_JSON)
				.content(testBooksAsJSON);
		
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkContent = content().json(savedBookAsJSON);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
		
	}
	@Test
	void testGetAll() throws Exception {
		String savedBookAsJSON = this.mapper.writeValueAsString(List.of(new Librarian(1, "Harry Potter", 300, "JK Rowling", 5)));
		
	}
	
	@Test
	void testGetById() throws Exception{
		final Librarian savedBook = new Librarian(1, "Harry Potter", 300, "JK Rowling", 5);
		String savedBookAsJSON = this.mapper.writeValueAsString(savedBook);
		
		RequestBuilder request = get("/getBook/" + savedBook.getId());
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(savedBookAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	}	
		
void testCreateAbridged() throws Exception {
	final String testBookAsJSON = this.mapper
			.writeValueAsString(new Librarian(1, "Harry Potter", 300, "JK Rowling", 5));
	final String savedBookAsJSON = this.mapper.writeValueAsString(new Librarian(1, "Harry Potter", 300, "JK Rowling", 5));
	
	this.mvc.perform(post("/createBook").contentType(MediaType.APPLICATION_JSON).content(testBookAsJSON)).
	andExpect(status().isCreated()).andExpect(content().json(savedBookAsJSON));
}
	}	

