package lms.controller;

import java.util.List;
import java.util.Optional;

import lms.dto.AuthenticateDto;
import lms.serviceImpl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lms.entities.UserDetails;
import lms.serviceImpl.UserServiceImpl;
import lms.services.UserService;


/**
 * this class is used to create controller for getAllUser , userSignUp and adminSignUp
 * by using methods of {@link UserServiceImpl}
 *
 * @author ashutosh.baranwal , sparsh.gupta
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/user/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserDetails> getAllUser() {
        return this.userService.getAllUser();
    }

    @PostMapping("user/signUp")
    public ResponseEntity<UserDetails> userSignUp(@RequestBody UserDetails userDetails,
                                                  @RequestParam(name = "countryname") String countryName,
                                                  @RequestParam(name = "statename") String stateName,
                                                  @RequestParam(name = "cityname") String cityName) {
        System.out.println(userDetails);
        try {
            return ResponseEntity.of(Optional.of(userService.signUp(userDetails,
                    countryName, stateName, cityName)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("admin/signUp")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserDetails> adminSignUp(@RequestBody UserDetails userDetails,
                                                   @RequestParam(name = "countryname") String countryName,
                                                   @RequestParam(name = "statename") String stateName,
                                                   @RequestParam(name = "cityname") String cityName) {

        try {
            return ResponseEntity.of(Optional.of(userService.adminsignUp(userDetails,
                    countryName, stateName, cityName)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthenticateDto authRequest) {
        System.out.println(authRequest.getEmail());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getEmail());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}