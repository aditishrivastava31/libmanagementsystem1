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

	private Long bookId;

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

	public void setStarRating(StarRating starRating) {
		this.starRating = starRating;
	}

	public Long getBookId() {
		return bookId;
	}

	public BookReview(Long ratingId, String comments, StarRating starRating, Long bookId) {
		this.ratingId = ratingId;
		this.comments = comments;
		this.starRating = starRating;
		this.bookId = bookId;
	}

	public BookReview() {
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
}
