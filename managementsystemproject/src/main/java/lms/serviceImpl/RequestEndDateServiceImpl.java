package lms.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import lms.dto.RequestEnddatedto;
import lms.entities.BookIssueDetails;
import lms.entities.RequestExtension;
import lms.repositories.BookIssueRepository;
import lms.repositories.RequestExtensionRepository;
import lms.services.RequestEndDateService;

@Service
public class RequestEndDateServiceImpl implements RequestEndDateService {

	private BookIssueRepository bookIssueRepository;
	
	
	private EmailServiceImpl emailServiceImpl;
	
	private RequestExtensionRepository requestExtensionRepository;
	

	public RequestEndDateServiceImpl() {

	}

	@Autowired
	public RequestEndDateServiceImpl(BookIssueRepository bookIssueRepository,EmailServiceImpl emailServiceImpl,RequestExtensionRepository requestExtensionRepository) {
		this.emailServiceImpl=emailServiceImpl;
		this.bookIssueRepository = bookIssueRepository;
		this.requestExtensionRepository=requestExtensionRepository;
		
	}

	@Override
	public List<RequestEnddatedto> getbookextensions() {

		List<RequestEnddatedto> requestEnddatedtos = new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			requestExtensionRepository.findAll().forEach(requestextension -> {
			BookIssueDetails bookIssueDetails=requestextension.getIssueId();	
			RequestEnddatedto requestEnddatedto = new RequestEnddatedto();
			requestEnddatedto.setUsername(bookIssueDetails.getUserDetail().getUserName());
			requestEnddatedto.setBooktitle(bookIssueDetails.getBookDetails().getBookName());
			requestEnddatedto.setIssueReturnDate(formatter.format(bookIssueDetails.getIssueEndDate()));
			Calendar c = Calendar.getInstance();
			c.setTime(bookIssueDetails.getIssueEndDate());
			c.add(Calendar.DATE, 10);
			requestEnddatedto.setRequestExtension(formatter.format(c.getTime()));
			requestEnddatedto.setIssueId(bookIssueDetails.getId());
			requestEnddatedtos.add(requestEnddatedto);
		});
		
		return requestEnddatedtos;
	}

	@Override
	public String acceptandreject(long id, int value) throws MessagingException {
		BookIssueDetails bookIssueDetails=bookIssueRepository.findById(id).orElse(null);
		emailServiceImpl.setBookIssueDetails(bookIssueDetails);
		if(value==0){
			emailServiceImpl.rejectEndDateEmailSender();
			deletetheExtension(bookIssueDetails);
			return "rejection";
		}
		
		else {
			Date issueenddate=bookIssueDetails.getIssueEndDate();
			Calendar c = Calendar.getInstance();
			c.setTime(issueenddate);
			c.add(Calendar.DATE, 10);
			bookIssueDetails.setIssueEndDate(c.getTime());
			bookIssueRepository.save(bookIssueDetails);
			emailServiceImpl.acceptEndDateEmailSender();
			deletetheExtension(bookIssueDetails);
			return "success";
		}
		
	}

	@Override
	public String addRequestEndExtension(long issueId){
		BookIssueDetails bookIssueDetails=bookIssueRepository.findById(issueId).orElse(null);
		if (bookIssueDetails==null) 
		{
			return "bookIssue details was not";
		}
		else {
			List<RequestExtension> requestExtensions=requestExtensionRepository.findByissueId(bookIssueDetails);
			if(requestExtensions.size()!=0) {
				return "request was already submitted";
			}
			else {
				RequestExtension requestExtension=new RequestExtension();
				requestExtension.setIssueId(bookIssueDetails);
				requestExtensionRepository.save(requestExtension);
				return "request was submitted for the extension of 10 days";
				
			}
		}
		
		
	}
	
	public void deletetheExtension(BookIssueDetails bookIssueDetails){
		List<RequestExtension> requestExtensions=requestExtensionRepository.findByissueId(bookIssueDetails);
		requestExtensions.forEach(reqeusteExtension->{
			requestExtensionRepository.deleteById(reqeusteExtension.getRequestextensionId());
		});
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
