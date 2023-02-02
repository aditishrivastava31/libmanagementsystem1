package lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lms.dto.BookDetailssenddto;
import lms.entities.BookDetails;
import lms.services.BookDetailsService;

/*
  THIS CLASS CONTAINS THE URLS FOR CONTROLLER OF 
  ADD BOOK DETAILS ,LEND AND FOR COMMON SEARCH OF THE BOOK
 */

@RestController
public class BookDetailsController {

	public BookDetailsService bookDetailsService;

	@Autowired
	public BookDetailsController(BookDetailsService bookDetailsService) {
		this.bookDetailsService = bookDetailsService;
	}

	public BookDetailsController() {

	}

	@PostMapping("/addbookDetails")
	public ResponseEntity<BookDetails> addbookdetails(@RequestBody BookDetails bookDetails) {

		try {
			return new ResponseEntity<>(bookDetailsService.addbookdetails(bookDetails), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GetMapping("/getbookdetails/{name}")
	public List<BookDetailssenddto> getbookdetails(@PathVariable("name") String name) {
		return bookDetailsService.getallbookdetails(name);

	}

	@PostMapping("/lend/{user_id}/{book_id}")
	public String lend_book(@PathVariable("user_id") long uid, @PathVariable("book_id") long bid) {
		String status = bookDetailsService.lend_book(uid, bid);
		return status;
	}

	@GetMapping("/getbookdetailsbyid/{id}")
	public BookDetails getbookdetailsbyid(@PathVariable("id") long id) {
		return bookDetailsService.getbookdetailsbyid(id);

	}

}
