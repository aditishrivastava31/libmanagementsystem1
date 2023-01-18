package com.library.managementsystemproject.entities;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Author{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long authorId;

	private String authorName;
	
	
	@ManyToMany(mappedBy = "authors")
	@JsonIgnore
	public Collection<BookDetails> bookDetails;

	public Author() {
	
		// TODO Auto-generated constructor stub
	}

	public Author(long authorId, String authorName, Collection<BookDetails> bookDetails) {
		this.authorId = authorId;
		this.authorName = authorName;
		this.bookDetails = bookDetails;
	}

	public Collection<BookDetails> getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(Collection<BookDetails> bookDetails) {
		this.bookDetails = bookDetails;
	}

	public long getAuthorId(){
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
