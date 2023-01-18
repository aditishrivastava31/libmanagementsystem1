package com.library.managementsystemproject.entities;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookIssueDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "book_Id")
	private Long bookId;
	
	@Column(name = "user_Id")
	private Long userId;
	
	@Column(name = "issue_Date")
	private Date issueDate;
	
	@Column(name = "issue_End_Date")
	private Date issueEndDate;
	
	@Column(name = "return_Date")
	private Date returnDate;

	public BookIssueDetails(Long id, Long bookId, Long userId, Date issueDate, Date issueEndDate, Date returnDate) {
		this.bookId = bookId;
		this.userId = userId;
		this.issueDate = issueDate;
		this.issueEndDate = issueEndDate;
		this.returnDate = returnDate;
	}

	public BookIssueDetails() {
		
	}

	public Long getId() {
		return id;
	}


	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getIssueEndDate() {
		return issueEndDate;
	}

	public void setIssueEndDate(Date issueEndDate) {
		this.issueEndDate = issueEndDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
	
	

	
	


}
