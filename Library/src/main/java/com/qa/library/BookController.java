package com.qa.library;
import java.util.ArrayList;
import java.util.List;

import com.qa.library.exception.BookNotFoundException;
import com.qa.library.service.BookService;
import com.qa.library.Librarian;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController // enables http endpoints AND tells Spring to make a Bean of this class

public class BookController {
	private BookService service;
	public BookController(BookService service) {
		super();
		this.service = service;
	}
	
//	private List<Librarian> book = new ArrayList<>();
	
	// if spring receives a GET request at /hello
	// call vv THIS vv method
	@GetMapping("/hello")
	public String hello() {
		return "Hello, people!";
	}

	@GetMapping("/goodbye")
	public String bye() {
		return "So long!";
	}
@GetMapping("/getBooks/{id}")
	public Librarian getBooksByIndex(@PathVariable Integer id) {
		return this.service.getBooksByIndex(id);
	//	return this.book.get(id);
	//return this.getBooksByIndex(id).findById(id).orElseThrow(BookNotFoundException::new);
	}
@GetMapping("/getAllBooks")
	public List<Librarian> getAllBooks() {
		return this.service.getAllBooks();
	}

	@PostMapping("/createBook")
	public ResponseEntity<Librarian> createBook(@RequestBody Librarian book) {
		System.out.println("CREATED BOOK: " + book);
//	this.book.add(book);
	//	Librarian responseBody = this.book.get(this.book.size() - 1);
		Librarian responseBody = this.service.createBook(book);
		ResponseEntity<Librarian>response =new ResponseEntity<Librarian>(responseBody, HttpStatus.CREATED);
		return response;
	}

	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Librarian> updateBook(@RequestBody Librarian book, @PathVariable Integer id) {
		//System.out.println("UPDATED BOOK: " + book);
		//System.out.println("ID: " + id);
		Librarian responseBody = this.service.updateBook(book, id);
		return new ResponseEntity<Librarian>(responseBody, HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/removeBooks/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
		boolean deleted = this.service.deleteBook(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 causes the body to be ignored
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
//	public ResponseEntity<Librarian> deleteBook(@PathVariable Integer id) {
	//Librarian toDelete = this.service.getBooksByIndex(id);
	//this.service.deleteBook(id);
	//return "deleted" + toDelete;
//	ResponseEntity<Librarian> deleted = this.service.deleteBook(id);
//	if (deleted) {
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	} else {
//		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		

//	return deleted;
	}
	}
