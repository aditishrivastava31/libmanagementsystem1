package lms.serviceImpl;

import java.util.List;

import lms.entities.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lms.repositories.AddressRepository;
import lms.repositories.CountryRepository;
import lms.repositories.StateAndCityRepository;
import lms.repositories.UserDetailsRepository;
import lms.services.UserService;


/**
 * this class Overrides all the methods of {@link UserService} and declare them
 * @author ashutosh.baranwal , sparsh.gupta
 *
 */

@Service
public class UserServiceImpl implements UserService {

	private UserDetailsRepository userDetailsRepository;

	private AddressRepository addressRepository;

	private CountryRepository countryRepository;

	private StateAndCityRepository stateAndCityRepository;

	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserDetailsRepository userDetailsRepository, AddressRepository addressRepository, CountryRepository countryRepository, StateAndCityRepository stateAndCityRepository,PasswordEncoder passwordEncoder) {
		this.userDetailsRepository = userDetailsRepository;
		this.addressRepository = addressRepository;
		this.countryRepository = countryRepository;
		this.stateAndCityRepository = stateAndCityRepository;
		this.passwordEncoder=passwordEncoder;
	}

	@Override
	public List<UserDetails> getAllUser() {
		return userDetailsRepository.findAll();
	}

	@Override
	public UserDetails signUp(UserDetails userDetails, String coutnryName, String stateName, String cityName) {
		userDetails.setRole("USER");
		return saveUserDetails(userDetails, coutnryName, stateName, cityName);
	}


	@Override
	public UserDetails adminsignUp(UserDetails userDetails, String coutnryName, String stateName, String cityName) {
		userDetails.setRole("ADMIN");
		userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
		return saveUserDetails(userDetails, coutnryName, stateName, cityName);
	}
	
	public UserDetails saveUserDetails(UserDetails userDetails, String coutnryName, String stateName, String cityName) {
		addressRepository.save(userDetails.getUserAddress());
		userDetails.getUserAddress().setStateAndCity(stateAndCityRepository
				.findStateCityId(countryRepository
						.findByCountryName(coutnryName).getId(), stateName, cityName));
		userDetails.setLendCount(5);
		userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
		return userDetailsRepository.save(userDetails);
	}


	@Override
	public UserDetails updated(long id) {
		UserDetails userDetails=null;
		
		if(id==1l) {
			 userDetails=userDetailsRepository.findById(id).orElse(null);
			userDetails.setRole("ADMIN");
			userDetailsRepository.save(userDetails);
			
			
		}
		else {
			 userDetails=userDetailsRepository.findById(id).orElse(null);
			userDetails.setRole("USER");
			userDetailsRepository.save(userDetails);

		}
		return userDetails;
	}

}
