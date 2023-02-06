package lms.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.dto.BookDetailssenddto;
import lms.entities.Author;
import lms.entities.BookDetails;
import lms.entities.BookIssueDetails;
import lms.entities.Category;
import lms.entities.UserDetails;
import lms.repositories.AuthorRepository;
import lms.repositories.BookIssueRepository;
import lms.repositories.BookRepository;
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

	public BookDetailsServiceImpl() {

	}

	@Autowired
	public BookDetailsServiceImpl(BookRepository bookRepository, UserDetailsRepository userDetailsRepository,
			AuthorRepository authorRepository, CategoryRepository categoryRepository,
			BookIssueRepository bookIssueRepository) {
		this.bookRepository = bookRepository;
		this.userDetailsRepository = userDetailsRepository;
		this.authorRepository = authorRepository;
		this.categoryRepository = categoryRepository;
		this.bookIssueRepository = bookIssueRepository;
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
			bookDetailssenddto.setAuthors(authorsList);
			bookDetailssenddtoList.add(bookDetailssenddto);
		});
		return bookDetailssenddtoList;

	}

	@Override
	public String lend_book(long uid, long bid) {
		UserDetails user = userDetailsRepository.findById(uid).orElse(null);
		BookDetails book = bookRepository.findById(bid).orElse(null);

		if (book == null || user == null){
			return "sorry you can't!!!";
		}

		else {
			if (user.getLendCount() != 0 && book.getQuantity() != 0) {
				user.setLendCount(user.getLendCount() - 1);
				book.setQuantity(book.getQuantity() - 1);
				userDetailsRepository.save(user);
				bookRepository.save(book);
				BookIssueDetails bookIssueDetails=new BookIssueDetails();
				bookIssueDetails.setBookDetails(book);
				bookIssueDetails.setUserDetail(user);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				 LocalDateTime localDateTime = LocalDateTime.now();  
				// System.out.println(formatter.format(now));
				 
				
				try {
					bookIssueDetails.setIssueDate(formatter.parse(localDateTime.toString()));
					bookIssueDetails.setIssueEndDate(formatter.parse(localDateTime.plusDays(7).toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				//bookIssueDetails.setIssueEndDate(null);
				bookIssueDetails.setReturnDate(null);
				bookIssueRepository.save(bookIssueDetails);
				System.out.println(bookIssueDetails);
				return "success";
			} else if (user.getLendCount() == 0) {
				return "sorry limit exceeded!!!";
			} else if (book.getQuantity() == 0) {
				return "sorry Book is not available!!!";
			} else {
				return null;
			}
		}
	}

	@Override
	public BookDetails getbookdetailsbyid(long id) {
		return bookRepository.findById(id).orElse(null);
	}

}
