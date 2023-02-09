package lms.services;

import jakarta.mail.MessagingException;

public interface EmailService {

	void sendEmail(String message) throws MessagingException;
}
