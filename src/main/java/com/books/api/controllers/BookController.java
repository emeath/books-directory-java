package com.books.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.api.DTO.BookDTO;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneBook(@PathVariable(value="id") Long id) {
		Optional<BookModel> bookModelOptional = bookService.findById(id);
		if(!bookModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(bookModelOptional.get());
	}
	
	@PostMapping
	public ResponseEntity<Object> sabeBook(@RequestBody @Valid BookDTO bookDTO) {
		if(bookService.existsByName(bookDTO.getName())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Book already registered!");
		}
		
		var bookModel = new BookModel();
		BeanUtils.copyProperties(bookDTO, bookModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(bookModel));
	}
	
}
