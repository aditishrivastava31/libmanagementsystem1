package lms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.dto.BookReviewdto;
import lms.entities.BookDetails;
import lms.entities.BookReview;
import lms.repositories.BookRepository;
import lms.repositories.BookReviewRepository;
import lms.repositories.UserDetailsRepository;
import lms.services.Bookreviewservices;



/*
 * this class is used to implement book review 
 */



@Service
public class BookReviewsServiceImpl  implements Bookreviewservices{
	
	
	
	public BookReviewRepository bookReviewRepository;
	
	public BookRepository bookRepository;
	
	public UserDetailsRepository userDetailsRepository;
	

	public BookReviewsServiceImpl() {

			
	}

	
	@Autowired
	public BookReviewsServiceImpl(BookReviewRepository bookReviewRepository, BookRepository bookRepository,
			UserDetailsRepository userDetailsRepository) {
		this.bookReviewRepository = bookReviewRepository;
		this.bookRepository = bookRepository;
		this.userDetailsRepository = userDetailsRepository;
	}



	@Override
	public BookReview addreviewdetails(BookReview book_Review) {
		return null;
	}

	@Override
	public BookReview addreviewbyids(BookReview bookReview, long uid, long bid) {
	bookReview.setBookdetails(bookRepository.findById(bid).orElse(null));
	bookReview.setUserdetails(userDetailsRepository.findById(uid).orElse(null));
	return bookReviewRepository.save(bookReview);
		
	}


	@Override
	public List<BookReviewdto> getreviewbybookid(long id) {
	
		List<BookReviewdto> Reviewdtoslist=new ArrayList<>();
		
		BookDetails bookDetails=bookRepository.findById(id).orElse(new BookDetails());
	      
		bookReviewRepository.findByBookdetails(bookDetails);
				
		System.out.println(bookReviewRepository.findByBookdetails(bookDetails));
		
		bookReviewRepository.findByBookdetails(bookDetails).forEach(n->{
				BookReviewdto bookReviewdto=new BookReviewdto();
				bookReviewdto.setComments(n.getComments());
				bookReviewdto.setStarRating(n.getStarRating());
				bookReviewdto.setUsername(n.getUserdetails().getUserName());
				Reviewdtoslist.add(bookReviewdto);
		});
		
		return Reviewdtoslist;
	}

}
