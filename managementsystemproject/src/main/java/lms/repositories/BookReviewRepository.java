package lms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lms.entities.BookDetails;
import lms.entities.BookIssueDetails;
import lms.entities.BookReview;
import lms.entities.UserDetails;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {

    public List<BookReview> findByBookdetails(BookDetails bookDetails);
    
    
    List<BookReview> findByBookdetailsAndUserdetails(BookDetails bookDetails, UserDetails userDetails);


}
