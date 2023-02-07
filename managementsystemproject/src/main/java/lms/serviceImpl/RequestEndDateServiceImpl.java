package lms.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import lms.dto.RequestEnddatedto;
import lms.entities.BookIssueDetails;
import lms.repositories.BookIssueRepository;
import lms.services.RequestEndDateService;

@Service
public class RequestEndDateServiceImpl implements RequestEndDateService {

	private BookIssueRepository bookIssueRepository;

	public RequestEndDateServiceImpl() {

	}

	@Autowired
	public RequestEndDateServiceImpl(BookIssueRepository bookIssueRepository) {

		this.bookIssueRepository = bookIssueRepository;
	}

	@Override
	public List<RequestEnddatedto> getbookextensions() {

		List<RequestEnddatedto> requestEnddatedtos = new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		bookIssueRepository.findAll().forEach(n -> {
			RequestEnddatedto requestEnddatedto = new RequestEnddatedto();
			requestEnddatedto.setUsername(n.getUserDetail().getUserName());
			requestEnddatedto.setBooktitle(n.getBookDetails().getBookName());
			requestEnddatedto.setIssueReturnDate(formatter.format(n.getIssueEndDate()));
			Calendar c = Calendar.getInstance();
			c.setTime(n.getIssueEndDate());
			c.add(Calendar.DATE, 10);
			requestEnddatedto.setRequestExtension(formatter.format(c.getTime()));
			requestEnddatedto.setIssueId(n.getId());
			requestEnddatedtos.add(requestEnddatedto);
		});
		System.out.println(bookIssueRepository.findAll());

		return requestEnddatedtos;
	}

	@Override
	public String acceptandreject(long id, int value) {
		if(value==1) {
			return "rejection";
		}
		
		else {
			BookIssueDetails bookIssueDetails=bookIssueRepository.findById(id).orElse(null);
			Date issueenddate=bookIssueDetails.getIssueEndDate();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(issueenddate);
			c.add(Calendar.DATE, 10);
			bookIssueDetails.setIssueEndDate(c.getTime());
			bookIssueRepository.save(bookIssueDetails);
			return "success";
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
