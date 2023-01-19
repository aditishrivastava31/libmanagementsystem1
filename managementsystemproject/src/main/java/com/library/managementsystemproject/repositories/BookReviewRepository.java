package com.library.managementsystemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.managementsystemproject.entities.BookDetails;


	
	public interface BookReviewRepository extends JpaRepository<BookDetails,Long> {
			
	

}
