package lms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.dto.BookDetailssenddto;
import lms.entities.BookDetails;
import lms.repositories.BookRepository;
import lms.services.BookDetailsService;

@Service
public class BookDetailsServiceImpl implements BookDetailsService{
	
	public BookRepository bookRepository;

	@Autowired
	public BookDetailsServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public BookDetailsServiceImpl() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public BookDetails addbookdetails(BookDetails bookDetails) {
		// TODO Auto-generated method stub
		return bookRepository.save(bookDetails);
	}

	@Override
	public List<BookDetailssenddto> getallbookdetails(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	

}
