package lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lms.entities.RequestBookDetails;
import lms.entities.StateAndCity;

/**
 * this interface will be used to connect {@link StateAndCity} from database
 * @author ashutosh.baranwal , sparsh.gupta
 *
 */

public interface StateAndCityRepository extends JpaRepository<StateAndCity, Long> {
	
	@Query(value = "select * from state_and_city where country_id=?1 and state_name=?2 and city_name=?3" , nativeQuery = true)
	StateAndCity findStateCityId(Long countryId , String stateName, String cityName);

}
