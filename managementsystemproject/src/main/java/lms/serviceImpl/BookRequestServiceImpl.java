package lms.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.dto.BookRequestDto;
import lms.entities.RequestBookDetails;
import lms.entities.RequestBookDetails.IsActive;
import lms.entities.UserDetails;
import lms.repositories.RequestBookDetailsRepository;
import lms.repositories.UserDetailsRepository;
import lms.services.BookRequestService;

/**
 * this class mainly allow to add some business functionalities.
 * @author pragya.singh
 *
 */

@Service
public class BookRequestServiceImpl implements BookRequestService {

	@Autowired
	public RequestBookDetailsRepository requestBookDetailsRepository;

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	

	@Override
	public String addrequestBookDetails(RequestBookDetails requestBookDetails, long id) {
		List<RequestBookDetails> requestBookDetailsList = requestBookDetailsRepository.findAll();
		String messageString = null;
		if(requestBookDetailsList.size()==0) {
			requestBookDetailsRepository.save(requestBookDetails);
			messageString= "Your request has been submitted..";
		}
		else {
			for (RequestBookDetails requestBookDetails2 : requestBookDetailsList) {
				if ((requestBookDetails.getBookName().toLowerCase()).equals(requestBookDetails2.getBookName().toLowerCase())) {
					messageString="Book is already requested..";
				} else {
					requestBookDetails.setIsActive(IsActive.Pending);
					requestBookDetails.setUserDetail(userDetailsRepository.findById(id).get());
					requestBookDetailsRepository.save(requestBookDetails);
					messageString= "Your request has been submitted..";
				} 
			}
		}
		return messageString;

	}
	@Override
	public List<RequestBookDetails> getallbookRequest() {
		return requestBookDetailsRepository.findAll();
	}
	
	@Override
	public List<RequestBookDetails> getAllRequestDetails(long id){
		return  requestBookDetailsRepository.findByUserDetail(userDetailsRepository.findById(id));
	}
		
	

	@Override
	public void deleteBookRequest(long userId , long requestBookId) {
	
		Optional<UserDetails> userDetails = userDetailsRepository.findById(userId);
		if(userDetails.get().isAdmin()==true) {
			requestBookDetailsRepository.deleteById(requestBookId);
		}
	}
	
	@Override
	public List<BookRequestDto> getAllRequestBook(long id){
		List<BookRequestDto> bookRequestDtos = new  ArrayList<>();
		List<RequestBookDetails> requestBookDetails =requestBookDetailsRepository.findByUserDetail(userDetailsRepository.findById(id));
		System.out.println(requestBookDetails);
		long i=1;
		for(RequestBookDetails requestBookDetails2:requestBookDetails) {
			BookRequestDto bookRequestDto=new BookRequestDto();
			bookRequestDto.setsNo(i++);
			bookRequestDto.setBookName(requestBookDetails2.getBookName());
			bookRequestDto.setAuthorName(requestBookDetails2.getAuthorName());
			bookRequestDto.setIsActive(IsActive.Pending);
			bookRequestDtos.add(bookRequestDto);
		}
		return bookRequestDtos;
	}

	

	@Override
	public List<BookRequestDto> updatestatus(long id,RequestBookDetails statusIsActive){
		Optional<RequestBookDetails> requestBookDetails= requestBookDetailsRepository.findById(id);
		requestBookDetails.get().setIsActive(statusIsActive.getIsActive());
		requestBookDetailsRepository.save(requestBookDetails.get());
		System.out.println("successfully save");
		
		BookRequestDto bookRequestDto1=new BookRequestDto();
		List<BookRequestDto> bookRequestDtos1 = new  ArrayList<>();
		List<RequestBookDetails> requestBookDetails1 =requestBookDetailsRepository.findByUserDetail(userDetailsRepository.findById(id));
		System.out.println(requestBookDetails);
		long i=1;
		for(RequestBookDetails requestBookDetails2:requestBookDetails1) {
			bookRequestDto1.setsNo(i++);
			bookRequestDto1.setBookName(requestBookDetails2.getBookName());
			bookRequestDto1.setAuthorName(requestBookDetails2.getAuthorName());
			bookRequestDto1.setIsActive(requestBookDetails2.getIsActive());
			bookRequestDtos1.add(bookRequestDto1);
		}
		return bookRequestDtos1;
		
	}
}
	

			

