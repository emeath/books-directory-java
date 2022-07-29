package com.books.api.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class BookDTO {
	
	@NotBlank	
	private String name;
	
	@NotBlank
	private String authorName;
	
	@Min(value = 10, message = "Pages should not be less than that")
	private int pages;
	
	@NotBlank
	private String genre;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
