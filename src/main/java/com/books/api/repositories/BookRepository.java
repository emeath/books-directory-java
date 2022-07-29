package com.books.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.api.models.BookModel;

public interface BookRepository extends JpaRepository<BookModel, Long>{

	boolean existsByName(String name);

}
