package lms.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lms.entities.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.dto.BookRequestDto;
import lms.entities.RequestBookDetails;
import lms.entities.RequestBookDetails.IsActive;
import lms.repositories.RequestBookDetailsRepository;
import lms.repositories.UserDetailsRepository;
import lms.services.BookRequestService;

/**
 * this class mainly allow to add some business functionalities.
 * 
 * @author pragya.singh
 *
 */

@Service
public class BookRequestServiceImpl implements BookRequestService {

	public RequestBookDetailsRepository requestBookDetailsRepository;

	private UserDetailsRepository userDetailsRepository;
	
	@Autowired
	public BookRequestServiceImpl(RequestBookDetailsRepository requestBookDetailsRepository,
			UserDetailsRepository userDetailsRepository) {
		super();
		this.requestBookDetailsRepository = requestBookDetailsRepository;
		this.userDetailsRepository = userDetailsRepository;
	}


    @Override
    public String addrequestBookDetails(RequestBookDetails requestBookDetails, long id) {
        List<RequestBookDetails> requestBookDetailsList = requestBookDetailsRepository.findAll();
        String messageString = null;
        if (requestBookDetailsList.size() == 0) {
        	 requestBookDetails.setIsActive(IsActive.Pending);
             requestBookDetails.setUserDetail(userDetailsRepository.findById(id).get());
            requestBookDetailsRepository.save(requestBookDetails);
            messageString = "Your request has been submitted..";
        } else {
            for (RequestBookDetails requestBookDetails2 : requestBookDetailsList) {
                if ((requestBookDetails.getBookName().toLowerCase())
                        .equals(requestBookDetails2.getBookName().toLowerCase())) {
                    messageString = "Book is already requested..";
                } else {
                    requestBookDetails.setIsActive(IsActive.Pending);
                    requestBookDetails.setUserDetail(userDetailsRepository.findById(id).get());
                    requestBookDetailsRepository.save(requestBookDetails);
                    messageString = "Your request has been submitted..";
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
	public List<RequestBookDetails> getAllRequestDetails(long id) {
		return requestBookDetailsRepository.findByUserDetail(userDetailsRepository.findById(id));
	}

	@Override
	public void deleteBookRequest(long userId, long requestBookId) {

		Optional<UserDetails> userDetails = userDetailsRepository.findById(userId);
		if (userDetails.get().getRole().equals("ADMIN")) {
			requestBookDetailsRepository.deleteById(requestBookId);
		}
	}

	@Override
	public List<BookRequestDto> getAllRequestBook() {
		List<BookRequestDto> bookRequestDtos = new ArrayList<>();
		List<RequestBookDetails> requestBookDetails = requestBookDetailsRepository.findAll();
		for (RequestBookDetails requestBookDetails2 : requestBookDetails) {
			bookRequestDtos.add(setBookRequestDto(requestBookDetails2));
		}
		return bookRequestDtos;
	}

	@Override
	public BookRequestDto updatestatus(long requestId,int isActive) {
		RequestBookDetails requestBookDetails = requestBookDetailsRepository.findById(requestId).get();
		requestBookDetails.setIsActive(IsActive.values()[isActive]);
		requestBookDetailsRepository.save(requestBookDetails);
		BookRequestDto bookRequestDto = setBookRequestDto(requestBookDetailsRepository.findById(requestId).get());
		return bookRequestDto;
	}

	public BookRequestDto setBookRequestDto(RequestBookDetails requestBookDetail) {
		
		BookRequestDto bookRequestDto = new BookRequestDto();
		bookRequestDto.setRequestId(requestBookDetail.getRequestBookId());
		bookRequestDto.setBookName(requestBookDetail.getBookName());
		bookRequestDto.setAuthorName(requestBookDetail.getAuthorName());
		bookRequestDto.setIsActive(requestBookDetail.getIsActive());
		
		return bookRequestDto;

	}


}
