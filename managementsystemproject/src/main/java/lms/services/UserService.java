package lms.services;

import lms.entities.UserDetails;

import java.util.List;


/**
 * this interface will be used to define service methods for {@link UserDetails}
 * @author ashutosh.baranwal , sparsh.gupta
 *
 */

public interface UserService {
	
	public UserDetails signUp(UserDetails userDetails , String countryName , String stateName , String cityName);
	
	public List<UserDetails> getAllUser();

	public UserDetails adminsignUp(UserDetails userDetails , String countryName , String stateName , String cityName);
}

