package lms.serviceImpl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lms.entities.BookIssueDetails;
import lms.services.EmailService;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * This class will override the method of {@link EmailService} and also used to
 * create body for Accept End Date , Reject End Date and Issue Book.
 * 
 * @author ashutosh.baranwal , sparsh.gupta
 *
 */
@Service
public class EmailServiceImpl implements EmailService {

	private JavaMailSender mailSender;

	private BookIssueDetails bookIssueDetails;

	public EmailServiceImpl(JavaMailSender mailSender1) {
		this.mailSender = mailSender1;
	}

	String subject = "Regarding End Date Request";

	@Override
	public void sendEmail(String message) throws MessagingException {
		String to = bookIssueDetails.getUserDetail().getEmail();
		MimeMessage emailmMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(emailmMessage, true);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(message, true);
		mailSender.send(emailmMessage);
	}

	public void acceptEndDateEmailSender() throws MessagingException {
		String message = "Dear " + bookIssueDetails.getUserDetail().getUserName()
				+ " your request for extending end date of " + bookIssueDetails.getBookDetails().getBookName()
				+ " is accepted!";
		sendEmail(message);
	}

	public void rejectEndDateEmailSender() throws MessagingException {
		String message = "Dear " + bookIssueDetails.getUserDetail().getUserName()
				+ " your request for extending end date of " + bookIssueDetails.getBookDetails().getBookName()
				+ " is rejected!";
		sendEmail(message);
	}

	public void issueBookEmailSender() {
		String message = "Dear " + bookIssueDetails.getUserDetail().getUserName() + " your request for issuing "
				+ bookIssueDetails.getBookDetails().getBookName()
				+ " has been completed . Enjoy Reading! And kindly return the book before "
				+ bookIssueDetails.getIssueEndDate() + " . ThankYou!";
		subject = "Book Issue";
		try {
			sendEmail(message);
		} catch (MessagingException e) {

			e.printStackTrace();
		}
	}

	public void setBookIssueDetails(BookIssueDetails bookIssueDetails) {
		this.bookIssueDetails = bookIssueDetails;
	}
}
