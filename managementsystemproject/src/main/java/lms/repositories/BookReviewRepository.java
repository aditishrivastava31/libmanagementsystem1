package lms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lms.entities.BookDetails;
import lms.entities.BookReview;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {

    public List<BookReview> findByBookdetails(BookDetails bookDetails);
    
    @Query(value="SELECT ifnull(avg(b.starRating),0) FROM BookReview b where b.bookdetails.bookId=?1")
    public double getAvgRating(long book_id);
    
    @Query(value="SELECT count(b) FROM BookReview b where b.bookdetails.bookId=?1")
    public int getRateCount(long book_id);

}
