package lms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lms.dto.BookReviewdto;
import lms.entities.BookReview;



/*
 * this is an interface for book review 
 */
@Service
public interface Bookreviewservices {
	
	

	public BookReview addreviewdetails(BookReview book_Review);

	public BookReview addreviewbyids(BookReview bookReview, long uid, long bid);

	public List<BookReviewdto> getreviewbybookid(long id);

	
	}


