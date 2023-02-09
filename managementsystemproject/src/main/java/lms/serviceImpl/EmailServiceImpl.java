package lms.serviceImpl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lms.entities.BookIssueDetails;
import lms.repositories.BookIssueRepository;
import lms.services.EmailService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	
    private JavaMailSender mailSender;
    
    private BookIssueDetails bookIssueDetails;
    
    public EmailServiceImpl(JavaMailSender mailSender1) {
        super();
        this.mailSender = mailSender1;
    }
    
    @Override
    public void sendEmail(String message ) throws MessagingException {
    	String subject = "Regarding End Date Request";
    	String to = bookIssueDetails.getUserDetail().getEmail();
        MimeMessage emailmMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(emailmMessage, true);
        helper.setTo(to);
         helper.setSubject(subject);
        helper.setText(message, true);
        mailSender.send(emailmMessage);
        System.out.println("-----------------Mail Send-----------------");
    }
    
    public void acceptEndDateEmailSender() throws MessagingException {
    	String message = "Dear "+bookIssueDetails.getUserDetail().getUserName()+" your request for extending end date of "
    					+bookIssueDetails.getBookDetails().getBookName()+"is accepted!"; 
    	sendEmail(message);
    }
    
    public void rejectEndDateEmailSender() throws MessagingException {
    	String message = "Dear "+bookIssueDetails.getUserDetail().getUserName()+" your request for extending end date of "
				+bookIssueDetails.getBookDetails().getBookName()+"is rejected!";
    	sendEmail(message);
    }

	public void setBookIssueDetails(BookIssueDetails bookIssueDetails) {
		this.bookIssueDetails = bookIssueDetails;
	}
}
