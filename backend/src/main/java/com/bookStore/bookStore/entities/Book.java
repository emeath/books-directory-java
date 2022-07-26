package com.bookStore.bookStore.entities;

import java.io.Serializable;

public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int pages;
	private String author;
	
	public Book() {
		
	}
	
	public Book(int id, String name, int pages, String author) {
		this.id = id;
		this.name = name;
		this.pages = pages;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
