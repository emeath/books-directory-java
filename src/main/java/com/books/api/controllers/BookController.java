package com.books.api.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<Page<BookModel>> getAllBooks(@PageableDefault(page = 0, size = 3, sort = "name", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll(pageable));
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBook(@PathVariable(value="id") Long id) {
		Optional<BookModel> bookModel = bookService.findById(id);
		if(!bookModel.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found!");
		}
		bookService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Book deleted sucessfully!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateBook(@PathVariable(value="id") Long id, @RequestBody @Valid BookDTO bookDTO){
		Optional<BookModel> bookModelOptional = bookService.findById(id);
		if(!bookModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found!");
		}
		var bookModel = new BookModel();
		bookModel.setId(bookModelOptional.get().getId());
		BeanUtils.copyProperties(bookDTO, bookModel);
		return ResponseEntity.status(HttpStatus.OK).body(bookService.save(bookModel));
	}
}
