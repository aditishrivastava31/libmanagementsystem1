package lms.dto;

import org.springframework.stereotype.Component;

import lms.entities.RequestBookDetails.IsActive;
@Component
public class BookRequestDto {
	private long sNo;
	private String bookName;
	private String authorName;
	private IsActive isActive;
	public long getsNo() {
		return sNo;
	}
	public void setsNo(long sNo) {
		this.sNo = sNo;
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
	public BookRequestDto(long sNo, String bookName, String authorName, IsActive isActive) {
		this.sNo = sNo;
		this.bookName = bookName;
		this.authorName = authorName;
		this.isActive = isActive;
	}
	public BookRequestDto() {
	}
	

	

}
