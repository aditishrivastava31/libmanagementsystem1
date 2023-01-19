package com.library.managementsystemproject.entities;

import jakarta.persistence.*;

@Entity
public class BookReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ratingId;
	
	private String comments;
	
	@Enumerated
	private StarRating starRating;

	

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public StarRating getStarRating() {
		return starRating;
	}

	public BookDetails getBookdetails() {
		return bookdetails;
	}

	public void setBookdetails(BookDetails bookdetails) {
		this.bookdetails = bookdetails;
	}

	public void setStarRating(StarRating starRating) {
		this.starRating = starRating;
	}

	
	@ManyToOne(targetEntity =BookDetails.class)
	@JoinColumn(name="book_id",referencedColumnName = "bookId")
	public BookDetails bookdetails;
	
	public BookReview() {
	
	}

	public BookReview(Long ratingId, String comments, StarRating starRating, BookDetails bookdetails) {
		super();
		this.ratingId = ratingId;
		this.comments = comments;
		this.starRating = starRating;
		this.bookdetails = bookdetails;
	}

	
}
