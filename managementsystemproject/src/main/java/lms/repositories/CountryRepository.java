package lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lms.entities.Country;

/**
 * this interface will be used to connect {@link Country} from database
 *
 * @author ashutosh.baranwal , sparsh.gupta
 */

public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByCountryName(String countryName);

}