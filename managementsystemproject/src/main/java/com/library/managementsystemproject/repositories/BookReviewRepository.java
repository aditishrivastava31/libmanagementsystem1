package com.library.managementsystemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.managementsystemproject.entities.BookReview;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {
	
	

	
}