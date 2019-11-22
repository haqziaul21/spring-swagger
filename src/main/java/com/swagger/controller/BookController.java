package com.swagger.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.model.Book;
import com.swagger.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/books")
@Api(value = "Book Management System", description = "Operations pertaining to book in Book Management System")
public class BookController {
	Logger log = LoggerFactory.getLogger(BookController.class);

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@ApiOperation(value = "View a list of available books", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping
	public ResponseEntity<List<Book>> findAll() {
		return ResponseEntity.ok(bookService.findAll());
	}

	@ApiOperation(value = "Add an book")
	@PostMapping
	public ResponseEntity<Book> create(@RequestBody Book book) {
		return ResponseEntity.ok(bookService.save(book));
	}

	@GetMapping("/{bookId}")
	@ApiOperation(value = "Get an book by Id")
	public ResponseEntity<Book> findById(@PathVariable Integer bookId) {
		Optional<Book> book = bookService.findById(bookId);

		if (!book.isPresent()) {
			log.error("bookId {} not existed", bookId);
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(book.get());
	}

	@ApiOperation(value = "Update an book")
	@PutMapping("/{bookId}")
	public ResponseEntity<Book> update(@PathVariable Integer bookId, @RequestBody Book book) {
		if (!bookService.findById(bookId).isPresent()) {
			log.error("bookId {} not existed", bookId);
			return ResponseEntity.notFound().build();
		}else {
			book.setBookId(bookId);
		}

		return ResponseEntity.ok(bookService.save(book));
	}

	@ApiOperation(value = "Update an book")
	@DeleteMapping("/{bookId}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer bookId) {
		if (!bookService.findById(bookId).isPresent()) {
			log.error("bookId {} not existed", bookId);
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok().build();
	}
}
