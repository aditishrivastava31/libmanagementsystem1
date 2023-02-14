package lms.Configuration;

import lms.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailssService implements UserDetailsService {

    @Autowired
    private UserDetailsRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<lms.entities.UserDetails> userInfo = repository.findByEmail(email);
        return userInfo.map(UserUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + email));

    }
}