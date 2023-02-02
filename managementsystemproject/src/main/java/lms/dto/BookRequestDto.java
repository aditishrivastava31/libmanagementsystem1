package lms.dto;

import lms.entities.RequestBookDetails.isActive;

public class BookRequestDto {
	private long sNo;
	private String bookName;
	private String authorName;
	private isActive isActive;
	
	
	
	public BookRequestDto() {
		
	}
	public BookRequestDto(long sNo, String bookName, String authorName,
			lms.entities.RequestBookDetails.isActive isActive) {

		this.sNo = sNo;
		this.bookName = bookName;
		this.authorName = authorName;
		this.isActive = isActive;
	}
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
	public isActive getIsActive() {
		return isActive;
	}
	public void setIsActive(isActive isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "BookRequestDto [sNo=" + sNo + ", bookName=" + bookName + ", authorName=" + authorName + ", isActive="
				+ isActive + "]";
	}
	
	
	
	

}
