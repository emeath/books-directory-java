package com.books.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.api.models.BookModel;
import com.books.api.services.BookService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<BookModel>> getAllBooks(){
		return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
	}
	
}
