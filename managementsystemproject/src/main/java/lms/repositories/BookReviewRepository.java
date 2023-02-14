package lms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lms.entities.BookDetails;
import lms.entities.BookReview;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {

    public List<BookReview> findByBookdetails(BookDetails bookDetails);


}
