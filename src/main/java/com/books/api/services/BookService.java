package com.books.api.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.books.api.models.BookModel;
import com.books.api.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public List<BookModel> findAll(){
		return bookRepository.findAll();
	}
	
	public boolean existsByName(String name) {
		return bookRepository.existsByName(name);
	}
	
	@Transactional
	public BookModel save(BookModel bookModel) {
		return bookRepository.save(bookModel);
	}

	public Optional<BookModel> findById(Long id) {
		return bookRepository.findById(id);
	}

	@Transactional
	public void delete(Long id) {
		bookRepository.deleteById(id);
		
	}

	public Page<BookModel> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

}
