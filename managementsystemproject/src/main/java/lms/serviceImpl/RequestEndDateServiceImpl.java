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

	@Autowired
	private BookIssueRepository bookIssueRepository;
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@Autowired
	private RequestExtensionRepository requestExtensionRepository;
	
	@Override
	public List<RequestEnddatedto> getbookextensions() {

		List<RequestEnddatedto> requestEnddatedtos = new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			requestExtensionRepository.findAll().forEach(requestextension -> {
			BookIssueDetails bookIssueDetails=requestextension.getIssueId();	
			RequestEnddatedto requestEnddatedto = new RequestEnddatedto(bookIssueDetails.getUserDetail().getUserName(),
					bookIssueDetails.getBookDetails().getBookName(),
					formatter.format(convertDate(bookIssueDetails.getIssueEndDate()).getTime()),
					formatter.format(bookIssueDetails.getIssueEndDate()) ,
					bookIssueDetails.getId());
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
			bookIssueDetails.setIssueEndDate(convertDate(issueenddate).getTime());
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
	
	public Calendar convertDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 10);
		return c;
	}
}
