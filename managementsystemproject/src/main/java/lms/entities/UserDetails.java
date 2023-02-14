package lms.entities;

import jakarta.persistence.*;
import lms.serviceImpl.UserServiceImpl;

/*
 * This class is used to refer user table in database and defines
 * all the fields and their data types.
 * @author sparsh.gupta, ashutosh.baranwal
 */
@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String userName;
    private String password;
    private String email;
    private long number;
    private String Role;
    private long lendCount;

    @OneToOne
    private Address userAddress;

    public UserDetails(long userId, String userName, String password, String email, long number, String role, long lendCount, Address userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.number = number;
        Role = role;
        this.lendCount = lendCount;
        this.userAddress = userAddress;
    }

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

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
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

    public UserDetails() {
    }
}