package lms.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import lms.dto.BookRequestDto;
import lms.entities.RequestBookDetails;
import lms.entities.UserDetails;
import lms.entities.RequestBookDetails.isActive;

/**
 * this interface will be used to connect BookRequestService
 * @author pragya.singh
 *
 */

public interface BookRequestService {

	String addrequestBookDetails(RequestBookDetails requestBookDetails , long id);
	
	List<RequestBookDetails> getallbookRequest();
	
	void deleteBookRequest(long userId ,long id);
	
	public List<RequestBookDetails> getAllRequestDetails(long id);
	
	public List<BookRequestDto> getAllRequestBook(long id);

}
