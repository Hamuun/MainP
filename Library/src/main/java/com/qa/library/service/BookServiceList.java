//package com.qa.library.service;
//
//	import java.util.ArrayList;
//	import java.util.List;
//
//	import org.springframework.http.HttpStatus;
//	import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.CrossOrigin;
//	import org.springframework.web.bind.annotation.DeleteMapping;
//	import org.springframework.web.bind.annotation.GetMapping;
//	import org.springframework.web.bind.annotation.PathVariable;
//	import org.springframework.web.bind.annotation.PostMapping;
//	import org.springframework.web.bind.annotation.PutMapping;
//	import org.springframework.web.bind.annotation.RequestBody;
//	import org.springframework.web.bind.annotation.RestController;
//
//import com.qa.library.Librarian;
//
//import java.util.List;
//
//
//@Service
//public class BookServiceList implements BookService{
//	
//		private List<Librarian> book = new ArrayList<>();
//		
//		// if spring receives a GET request at /hello
//		// call vv THIS vv method
//	
//	
//	@Override
//		public Librarian getBooksByIndex(Integer id) {
//			return this.book.get(id);
//		}
//	@Override
//		public List<Librarian> getAllBooks() {
//			return this.book;
//		}
//	@Override 
//	public Librarian createBook(Librarian book) {
//		System.out.println("CREATED BOOKS: " + book);
//		this.book.add(book);
//		return this.book.get(this.book.size() - 1);
//	}
//		
//	public Librarian updateBook(Librarian book, Integer id) {
//		System.out.println("UPDATED BOOKS: " + book);
//		System.out.println("ID: " + id);
//		return this.book.set(id, book);
//		}
////@Override
////		public void deleteBook(@PathVariable Integer id) {
////		Librarian toDelete = this.book.get(id);
////		this.book.remove(toDelete);
////		}
//
//}
//
//
