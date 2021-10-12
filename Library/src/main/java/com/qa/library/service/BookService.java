package com.qa.library.service;

import java.util.List;

import com.qa.library.*;

public interface BookService {
	public Librarian getBooksByIndex(Integer id);

	public List<Librarian> getAllBooks();

	public Librarian createBook(Librarian book);
	public Librarian updateBook(Librarian book, Integer id);

	public boolean deleteBook(Integer id);
}

