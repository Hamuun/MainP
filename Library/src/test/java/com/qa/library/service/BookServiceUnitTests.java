package com.qa.library.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.library.repo.BookRepo;
import com.qa.library.Librarian;
import com.qa.library.service.BookServiceDB;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookServiceUnitTests {
	
		@Autowired
		private BookServiceDB service;
		
		@MockBean  
		private BookRepo repo;
		
		@Test
		void testUpdate() {
			final Integer id = 1;
			Librarian book =new Librarian(1, "Harry", 300, "blue", 5);
			Optional<Librarian> optionalBook = Optional.of(book);
			
			Librarian newBook = new Librarian(id, "Divergent", 500, "blue",5);
			
			Mockito.when(this.repo.findById(id)).thenReturn(optionalBook);
			Mockito.when(this.repo.save(newBook)).thenReturn(newBook);
			
			assertThat(newBook).isEqualTo(this.service.updateBook(newBook, book.getId()));
			
			Mockito.verify(this.repo, Mockito.times(1)).findById(id);
			Mockito.verify(this.repo, Mockito.times(1)).save(newBook);
		}
		@Test
		void testCreate() {
		final Integer id = 1;
		Librarian book =new Librarian(1, "Harry", 300, "blue", 5);
		
		Mockito.when(this.repo.save(book)).thenReturn(book);
		
		assertThat(book).isEqualTo(this.service.createBook(book));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(book);
	}
		@Test
		void testgetBooks() {
			final Integer id = 1;
			Librarian book =new Librarian(1, "Harry", 300, "blue", 5);
			Optional<Librarian> optionalBook = Optional.of(book);
			
			
			Mockito.when(this.repo.findById(id)).thenReturn(optionalBook);
			
			assertThat(book).isEqualTo(this.service.getBooksByIndex(book.getId()));
			
			Mockito.verify(this.repo, Mockito.times(1)).findById(id);
			
		}
		
		@Test
		void testgetAllBooks() {
			final Integer id = 1;
			final List<Librarian> book = List.of(new Librarian(1, "Harry", 300, "blue", 5), new Librarian(2, "Harry", 300, "blue", 5));
		
			Mockito.when(this.repo.findAll()).thenReturn(book);
			
			assertThat(book).isEqualTo(this.service.getAllBooks());
			Mockito.verify(this.repo, Mockito.times(1)).findAll();
			
		}
		
			
		}

