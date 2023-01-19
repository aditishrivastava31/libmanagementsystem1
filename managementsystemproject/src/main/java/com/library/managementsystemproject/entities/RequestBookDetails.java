package com.library.managementsystemproject.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RequestBookDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long requestBookId;
	private boolean isActive;
	private String authorName;
	private String bookName;
	@ManyToOne
	@JoinColumn(name="userId")
	private UserDetails userDetail;
	
	public long getRequestBookId() {
		return requestBookId;
	}
	public void setRequestBookId(long requestBookId) {
		this.requestBookId = requestBookId;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public UserDetails getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetails userDetail) {
		this.userDetail = userDetail;
	}
	public RequestBookDetails(long requestBookId, boolean isActive, String authorName, String bookName,
			UserDetails userDetail) {
		this.requestBookId = requestBookId;
		this.isActive = isActive;
		this.authorName = authorName;
		this.bookName = bookName;
		this.userDetail = userDetail;
	}
}