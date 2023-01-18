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
	private Long book_Id;
	
	@Column(name = "user_Id")
	private Long user_Id;
	
	@Column(name = "issue_Date")
	private Date issue_Date;
	
	@Column(name = "issue_End_Date")
	private Date issue_End_Date;
	
	@Column(name = "return_Date")
	private Date return_Date;
	
	

	public BookIssueDetails() {

	}


	public BookIssueDetails(Long id, Long book_Id, Long user_Id, Date issue_Date, Date issue_End_Date,
			Date return_Date) {
		this.id = id;
		this.book_Id = book_Id;
		this.user_Id = user_Id;
		this.issue_Date = issue_Date;
		this.issue_End_Date = issue_End_Date;
		this.return_Date = return_Date;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getBook_Id() {
		return book_Id;
	}


	public void setBook_Id(Long book_Id) {
		this.book_Id = book_Id;
	}


	public Long getUser_Id() {
		return user_Id;
	}


	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}


	public Date getIssue_Date() {
		return issue_Date;
	}


	public void setIssue_Date(Date issue_Date) {
		this.issue_Date = issue_Date;
	}


	public Date getIssue_End_Date() {
		return issue_End_Date;
	}


	public void setIssue_End_Date(Date issue_End_Date) {
		this.issue_End_Date = issue_End_Date;
	}


	public Date getReturn_Date() {
		return return_Date;
	}


	public void setReturn_Date(Date return_Date) {
		this.return_Date = return_Date;
	}
	
	
	


}
