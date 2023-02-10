package lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import lms.dto.BookIssueDetailsDto;
import lms.serviceImpl.BookIssueServiceImpl;

@RestController
public class BookIssueController {

	@Autowired
	BookIssueServiceImpl bookIssueServiceImpl;

	@PostMapping("/lend/{user_id}/{book_id}")
	public String lend_book(@PathVariable("user_id") long uid, @PathVariable("book_id") long bid) throws MessagingException {
		String status = bookIssueServiceImpl.lend_book(uid, bid);
		return status;
	}

	@PostMapping("/return/{issue_id}")
	public String return_book(@PathVariable("issue_id") long id) {
		String status = bookIssueServiceImpl.return_book(id);
		return status;
	}

	@GetMapping("/totalBooks/{user_id}")
	public List<BookIssueDetailsDto> getAllBooks(@PathVariable("user_id") long uid) {
		return bookIssueServiceImpl.getIssuedBookDetails("total", uid);
	}

	@GetMapping("/issuedBooks/{user_id}")
	public List<BookIssueDetailsDto> getIssuedBooks(@PathVariable("user_id") long uid) {
		return bookIssueServiceImpl.getIssuedBookDetails("issued", uid);
	}

	@GetMapping("/readBooks/{user_id}")
	public List<BookIssueDetailsDto> getReadBooks(@PathVariable("user_id") long uid) {
		return bookIssueServiceImpl.getIssuedBookDetails("read", uid);
	}

	@GetMapping("/pendingBooks/{user_id}")
	public List<BookIssueDetailsDto> getPendingBooks(@PathVariable("user_id") long uid) {
		return bookIssueServiceImpl.getIssuedBookDetails("pending", uid);
	}
	
	@GetMapping("/getAllIssues")
	public List<BookIssueDetailsDto> getAllIssues(){
		return bookIssueServiceImpl.getAllIssuesToAdmin();
	}
	
}
