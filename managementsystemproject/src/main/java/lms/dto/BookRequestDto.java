package lms.dto;

import org.springframework.stereotype.Component;

import lms.entities.RequestBookDetails.IsActive;
@Component
public class BookRequestDto {
	private long requestId;
	private String bookName;
	private String authorName;
	private IsActive isActive;
	
	
	public BookRequestDto() {
		
	}
	public BookRequestDto(long requestId, String bookName, String authorName, IsActive isActive) {
	
		this.requestId = requestId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.isActive = isActive;
	}
	public long getRequestId() {
		return requestId;
	}
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public IsActive getIsActive() {
		return isActive;
	}
	public void setIsActive(IsActive isActive) {
		this.isActive = isActive;
	}

	

	

}
