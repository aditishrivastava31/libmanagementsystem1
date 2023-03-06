package lms.services;

import jakarta.mail.MessagingException;
import lms.serviceImpl.EmailServiceImpl;

/**
 * This interface is used to declare method for sending email and
 * implemented in class {@link EmailServiceImpl}
 *
 * @author ashutosh.baranwal , sparsh.gupta
 */

public interface EmailService {

    void sendEmail(String message) throws MessagingException;
    void forgetPasswordSendEMail(String email,String resetPasswordLink) throws MessagingException ;
}
