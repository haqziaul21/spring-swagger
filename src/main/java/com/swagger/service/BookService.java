package com.swagger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.swagger.model.Book;
import com.swagger.repository.BookRepo;

@Service
public class BookService {

	private final BookRepo bookRepo;

	public BookService(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	public Optional<Book> findById(Integer bookId) {
		return bookRepo.findById(bookId);
	}

	public List<Book> findAll() {
		return bookRepo.findAll();
	}

	public Book save(Book book) {
		return bookRepo.save(book);
	}

	public void deleteById(Integer bookId) {
		bookRepo.deleteById(bookId);
	}
}
