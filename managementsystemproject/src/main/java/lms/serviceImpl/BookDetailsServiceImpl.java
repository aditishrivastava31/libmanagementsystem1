package lms.serviceImpl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.dto.BookDetailssenddto;
import lms.entities.Author;
import lms.entities.BookDetails;
import lms.entities.Category;
import lms.entities.StarRating;
import lms.repositories.AuthorRepository;
import lms.repositories.BookIssueRepository;
import lms.repositories.BookRepository;
import lms.repositories.BookReviewRepository;
import lms.repositories.CategoryRepository;
import lms.repositories.UserDetailsRepository;
import lms.services.BookDetailsService;

/*
THIS CLASS IS USED TO IMPLEMENT THE
ADD BOOK DETAILS,LEND AND COMMON SEARCH
OF THE BOOK
*/

@Service
public class BookDetailsServiceImpl implements BookDetailsService {

	public BookRepository bookRepository;

	public UserDetailsRepository userDetailsRepository;
	
	public AuthorRepository authorRepository;
	
	public CategoryRepository categoryRepository;

	public BookIssueRepository bookIssueRepository;
	
	public BookReviewRepository bookReviewRepository;

	
	public BookDetailsServiceImpl() {

	}
	
	@Autowired
	public BookDetailsServiceImpl(BookRepository bookRepository, UserDetailsRepository userDetailsRepository,
			AuthorRepository authorRepository, CategoryRepository categoryRepository,BookReviewRepository bookReviewRepository,
			BookIssueRepository bookIssueRepository) {
		this.bookRepository = bookRepository;
		this.userDetailsRepository = userDetailsRepository;
		this.authorRepository = authorRepository;
		this.categoryRepository = categoryRepository;
		this.bookIssueRepository = bookIssueRepository;
		this.bookReviewRepository=bookReviewRepository;
	}

	@Override
	public BookDetails addbookdetails(BookDetails bookDetails) {
		List<Author> bookAuthors=new ArrayList<>();
		bookDetails.getAuthors().forEach(n->{
			List<Author> authors=authorRepository.findByAuthorName(n.getAuthorName());
			if(authors.size()==0) {
				authorRepository.save(n);
				bookAuthors.add(n);
			}
			else {
				bookAuthors.add(authors.get(0));
			}	
		});
		bookDetails.setAuthors(bookAuthors);
		
		//adding the category
		
		List<Category> categories=categoryRepository.findByCategoryName(bookDetails.getCategory().getCategoryName());
		if(categories.size()!=0) {
			bookDetails.setCategory(categories.get(0));
		}
		else {
			categoryRepository.save(bookDetails.getCategory());
		}
		
		return bookRepository.save(bookDetails);
		
	}

	@Override
	public List<BookDetailssenddto> getallbookdetails(String name) {

		List<BookDetailssenddto> bookDetailssenddtoList = new ArrayList<>();
		List<BookDetails> bookDetailsList = new ArrayList<>();
		bookRepository.getbookdetails(name).forEach(n -> {
			BookDetails bookDetails = bookRepository.findById(n).orElse(null);
			bookDetailsList.add(bookDetails);
		});
		bookDetailsList.forEach(n -> {
			BookDetailssenddto bookDetailssenddto = new BookDetailssenddto();
			bookDetailssenddto.setBook_id(n.getBookId());
			bookDetailssenddto.setQuantity(n.getQuantity());
			bookDetailssenddto.setBook_title(n.getBookName());
			bookDetailssenddto.setCategory(n.getCategory().getCategoryName());
			List<String> authorsList = n.getAuthors().stream().map(m -> m.getAuthorName()).collect(Collectors.toList());
			double avg=avergarating(n.getBookId());
			bookDetailssenddto.setAvg_rating(avg);
			bookDetailssenddto.setAuthors(authorsList);
			bookDetailssenddtoList.add(bookDetailssenddto);
		});
		return bookDetailssenddtoList;

	}

	@Override
	public BookDetailssenddto getbookdetailsbyid(long id) {
		//System.out.println(avergarating(id));
		BookDetailssenddto bookDetailssenddto=new BookDetailssenddto();
		BookDetails bookDetails=bookRepository.findById(id).orElse(null);
		if(bookDetails==null) {
			return null;
		}
		else {
			bookDetailssenddto.setBook_id(bookDetails.getBookId());
			bookDetailssenddto.setQuantity(bookDetails.getQuantity());
			bookDetailssenddto.setBook_title(bookDetails.getBookName());
			bookDetailssenddto.setCategory(bookDetails.getCategory().getCategoryName());
			List<String> authorsList = bookDetails.getAuthors().stream().map(m -> m.getAuthorName()).collect(Collectors.toList());
			bookDetailssenddto.setAuthors(authorsList);
			bookDetailssenddto.setAvg_rating(avergarating(id));
			return bookDetailssenddto;
		}
		
		
	}

	@Override
	public List<BookDetailssenddto> geteverybookdetails() {
		List<BookDetailssenddto> bookDetailssenddtoList = new ArrayList<>();
		bookRepository.findAll().forEach(n -> {
			BookDetailssenddto bookDetailssenddto = new BookDetailssenddto();
			bookDetailssenddto.setBook_id(n.getBookId());
			bookDetailssenddto.setQuantity(n.getQuantity());
			bookDetailssenddto.setBook_title(n.getBookName());
			bookDetailssenddto.setCategory(n.getCategory().getCategoryName());
			List<String> authorsList = n.getAuthors().stream().map(m -> m.getAuthorName()).collect(Collectors.toList());
			double avg=avergarating(n.getBookId());
			bookDetailssenddto.setAvg_rating(avg);
			bookDetailssenddto.setAuthors(authorsList);
			bookDetailssenddtoList.add(bookDetailssenddto);
		});
		return bookDetailssenddtoList;
		
	}
	
	public Double avergarating(long id){
		//System.out.println(bookReviewRepository.findByBookdetails(bookRepository.findById(id).orElse(null)));
		OptionalDouble avg=bookReviewRepository.findByBookdetails(bookRepository.findById(id).orElse(null)).stream().mapToInt(n->n.getStarRating().getRating()).average();
		if(avg.isPresent()) {  
			DecimalFormat decimalFormat =  new DecimalFormat("#0.0"); 

//			System.out.println(formatter.format(4.0));
			return Double.parseDouble(decimalFormat.format((double)avg.getAsDouble()));
		}
		
		else {
			return 0.0;
		}
		
		
	}

}
