package lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lms.dto.BookRequestDto;
import lms.entities.RequestBookDetails;
import lms.entities.UserDetails;
import lms.services.BookRequestService;


/**
 * This controller class is the final destination that a web request can reach.
 * Ater being invoked the controller method start process the web request by interacting with BookRequestService.
 * @author pragya.singh
 *
 */

@RestController
public class RequestBookController {
	
	
	@Autowired
	private BookRequestService bookRequestService;

	
	
	@PostMapping("/requestbook/{userId}")
	public String addRequestBookDetails(@RequestBody RequestBookDetails requestBookDetails , @PathVariable("userId") int id) {
		return bookRequestService.addrequestBookDetails(requestBookDetails , id);
	}
	
	@GetMapping("/requestbook")
	public List<RequestBookDetails> getBookRequestDetails(){
		return bookRequestService.getallbookRequest();
	}
	
	@GetMapping("/requestbookdetail/{userId}")
	public List<RequestBookDetails> getUserDetails(@PathVariable("userId") long id){
		return bookRequestService.getAllRequestDetails(id);
	}
	
	@DeleteMapping("/deleterequestbook/{requestbookid}/{userid}")
	public void deleteBookRequest(@PathVariable("userid") long id , @PathVariable("requestbookid") long requestBookId){
		bookRequestService.deleteBookRequest(id, requestBookId);
	}

	@GetMapping("/requestBookdto/{userId}")
	public List<BookRequestDto> getAllData(@PathVariable("userId") long id){
		List<BookRequestDto> bookRequestDtos=bookRequestService.getAllRequestBook(id);
		return bookRequestDtos;
	}

}
