package lms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lms.dto.BookDetailssenddto;
import lms.entities.BookDetails;

/*
 
 THIS iNTERFACE IS USED TO DECLARE THE
ADD BOOK DETAILS,LEND AND COMMON SEARCH
OF THE BOOK
 
 */

@Service
public interface BookDetailsService
{

	BookDetails addbookdetails(BookDetails bookDetails);

	List<BookDetailssenddto> getallbookdetails(String name);

	String lend_book(long uid, long bid);

	BookDetails getbookdetailsbyid(long id);

}
