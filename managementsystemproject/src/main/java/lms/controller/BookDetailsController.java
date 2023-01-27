package lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lms.dto.BookDetailssenddto;
import lms.entities.BookDetails;
import lms.services.BookDetailsService;

@RestController
public class BookDetailsController {

	public BookDetailsService bookDetailsService;

	@Autowired
	public BookDetailsController(BookDetailsService bookDetailsService) {
		
		this.bookDetailsService = bookDetailsService;
	}

	public BookDetailsController(){
	
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/addbookDetails")
	public BookDetails addbookdetails(@RequestBody BookDetails bookDetails)
	{
		System.out.println(bookDetails);
		
		return bookDetailsService.addbookdetails(bookDetails);
	
	}
	@GetMapping("/getbookdetails/{name}")
	public List<BookDetailssenddto> getbookdetails(@PathVariable("name") String name){
		
		return bookDetailsService.getallbookdetails(name);
		
	}
	
	
	
	
	
}
