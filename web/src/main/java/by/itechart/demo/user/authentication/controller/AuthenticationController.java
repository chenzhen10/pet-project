package by.itechart.demo.user.authentication.controller;


import by.itechart.demo.security.UserPrinciple;
import by.itechart.demo.security.jwt.JwtProvider;
import by.itechart.demo.security.jwt.model.JwtResponse;
import by.itechart.demo.user.model.User;
import by.itechart.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authenticate")
public class AuthenticationController {


    @Autowired
    private JwtProvider jwtProvider;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> authenticateUser(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUserName(), user.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(user.getUserName());
        UserPrinciple userDetails = (UserPrinciple) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt,userDetails.getAuthorities()));
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
