package lms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String userName;
	private String password;
	private String email;
	private long number;
	private boolean isAdmin;
	private long lendCount;
	
	@OneToOne
	private Address userAddress;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public long getLendCount() {
		return lendCount;
	}
	public void setLendCount(long lendCount) {
		this.lendCount = lendCount;
	}
	public Address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
	public UserDetails(long userId, String userName, String password, String email, long number, boolean isAdmin,
			long lendCount, Address userAddress) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.number = number;
		this.isAdmin = isAdmin;
		this.lendCount = lendCount;
		this.userAddress = userAddress;
	}
	public UserDetails() {
		
		
	}
	
	
	

	
}