package com.books.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
