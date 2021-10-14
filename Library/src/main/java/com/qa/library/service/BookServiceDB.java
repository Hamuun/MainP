package com.qa.library.service;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.library.Librarian;
import com.qa.library.exception.BookNotFoundException;
import com.qa.library.repo.BookRepo;

@Service
@Primary

public class BookServiceDB implements BookService{

	private BookRepo repo;

	public BookServiceDB(BookRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Librarian getBooksByIndex(Integer id) {
		return this.repo.findById(id).orElseThrow(BookNotFoundException::new);
	}
	@Override
	public List<Librarian> getBooksByName(String name) {
		return this.repo.findByName(name);
	}
	@Override
	public List<Librarian> getAllBooks() {
		return this.repo.findAll();
	}
	@Override
		public Librarian createBook(Librarian book) {
		return this.repo.save(book);
	}
	
	@Override
	public Librarian updateBook(Librarian book, Integer id) {
		Librarian toUpdate = this.repo.findById(id).get();
		toUpdate.setName(book.getName());
		toUpdate.setAuthor(book.getAuthor());
		toUpdate.setPagenum(book.getPagenum());
		toUpdate.setShelfnum(book.getShelfnum());
		return this.repo.save(toUpdate);
	}

	@Override
	public boolean deleteBook(Integer id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}




	

}

