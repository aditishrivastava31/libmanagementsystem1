package lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lms.entities.RequestBookDetails;

/**
 * this interface will be used to connect {@link RequestBookDetails} from database
 * @author ashutosh.baranwal
 *
 */


@EnableJpaRepositories
public interface RequestBookDetailsRepository extends JpaRepository<RequestBookDetails, Long> {

}
