package lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import lms.entities.BookReview;

public interface BookReviewRepository extends JpaRepository<BookReview, Long>{
	
	
}
