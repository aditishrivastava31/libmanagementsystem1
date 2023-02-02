package lms.entities;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BookIssueDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private Date issueDate;
	private Date issueEndDate;
	private Date returnDate;
	
	@ManyToOne
	@JoinColumn(name="bookId")
	private BookDetails bookDetails;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private UserDetails userDetail;
	

	public BookIssueDetails() {

	}

	public BookIssueDetails(Long id, Date issueDate, Date issueEndDate, Date returnDate, BookDetails bookDetails,
			UserDetails userDetail) {
		this.id = id;
		this.issueDate = issueDate;
		this.issueEndDate = issueEndDate;
		this.returnDate = returnDate;
		this.bookDetails = bookDetails;
		this.userDetail = userDetail;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BookDetails getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(BookDetails bookDetails) {
		this.bookDetails = bookDetails;
	}

	public UserDetails getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetails userDetail) {
		this.userDetail = userDetail;
	}
	
	
}