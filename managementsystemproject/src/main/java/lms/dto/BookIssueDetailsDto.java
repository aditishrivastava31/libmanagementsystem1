package lms.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookIssueDetailsDto {

	private long issue_id;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date issueDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date issueEndDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;

	private String bookTitle;

	private List<String> authors;

	private String userName;
	
	private Boolean isExtendable;

	public long getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(long issue_id) {
		this.issue_id = issue_id;
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

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getIsExtendable() {
		return isExtendable;
	}

	public void setIsExtendable(Boolean isExtendable) {
		this.isExtendable = isExtendable;
	}

	@Override
	public String toString() {
		return "BookIssueDetailsDto [issue_id=" + issue_id + ", issueDate=" + issueDate + ", issueEndDate="
				+ issueEndDate + ", returnDate=" + returnDate + ", bookTitle=" + bookTitle + ", authors=" + authors
				+ ", userName=" + userName + ", isExtendable=" + isExtendable + "]";
	}
	
	

}