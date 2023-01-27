package lms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lms.dto.BookDetailssenddto;
import lms.entities.BookDetails;

@Service
public interface BookDetailsService {

	BookDetails addbookdetails(BookDetails bookDetails);

	List<BookDetailssenddto> getallbookdetails(String name);
	
	
}
