package com.library.managementsystemproject.entity;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookIssueDetails {
	Date dNow = new Date();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "book_id")
	private Long book_id;
	
	@Column(name = "user_id")
	private Long user_id;
	
	@Column(name = "issue_date")
	private Date issue_date;
	
	@Column(name = "issue_end_date")
	private Date issue_end_date;
	
	@Column(name = "return_date")
	private Date return_date;
	
	

	public BookIssueDetails() {
		super();
	}

	public BookIssueDetails(Date dNow, Long id, Long book_id, Long user_id, Date issue_date, Date issue_end_date,
			Date return_date) {
		super();
		this.dNow = dNow;
		this.id = id;
		this.book_id = book_id;
		this.user_id = user_id;
		this.issue_date = issue_date;
		this.issue_end_date = issue_end_date;
		this.return_date = return_date;
	}

	public Date getdNow() {
		return dNow;
	}

	public void setdNow(Date dNow) {
		this.dNow = dNow;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Date getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}

	public Date getIssue_end_date() {
		return issue_end_date;
	}

	public void setIssue_end_date(Date issue_end_date) {
		this.issue_end_date = issue_end_date;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	
	

}
