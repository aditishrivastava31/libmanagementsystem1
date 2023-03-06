package lms.repositories;

import lms.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

/**
 * this interface will be used to connect {@link UserDetails} from database
 *
 * @author ashutosh.baranwal
 */

@EnableJpaRepositories
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    Optional<UserDetails> findByEmail(String email);
    public UserDetails findByResetpasswordtoken(String token);

}
