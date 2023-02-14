package lms.serviceImpl;

import java.util.List;

import lms.entities.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.repositories.AddressRepository;
import lms.repositories.CountryRepository;
import lms.repositories.StateAndCityRepository;
import lms.repositories.UserDetailsRepository;
import lms.services.UserService;


/**
 * this class Overrides all the methods of {@link UserService} and declare them
 *
 * @author ashutosh.baranwal , sparsh.gupta
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateAndCityRepository stateAndCityRepository;

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
        return saveUserDetails(userDetails, coutnryName, stateName, cityName);
    }

    public UserDetails saveUserDetails(UserDetails userDetails, String coutnryName, String stateName, String cityName) {
        addressRepository.save(userDetails.getUserAddress());

        userDetails.getUserAddress().setStateAndCity(stateAndCityRepository
                .findStateCityId(countryRepository
                        .findByCountryName(coutnryName).getId(), stateName, cityName));
        userDetails.setLendCount(5);
        return userDetailsRepository.save(userDetails);
    }

}
