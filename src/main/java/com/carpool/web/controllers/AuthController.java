package com.carpool.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carpool.web.models.RegistrationRequest;
import com.carpool.web.models.User;
import com.carpool.web.repositories.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  
    @Autowired
    private UserRepository userRepository;

    
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        //System.out.println("Recieved------------------------------------------");
        // Check if the username is already taken
        // if (userRepository.findByUsername(registrationRequest.getUsername())()) {
        //     return new ResponseEntity<>("Username is already taken", HttpStatus.BAD_REQUEST);
        // }

        // Create a new user
        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setPassword(registrationRequest.getPassword()); // You should hash the password, consider using BCryptPasswordEncoder

        // Save the user to the database
        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> authenticateUser(@RequestBody RegistrationRequest loginRequest) {
        // Simulate user validation; replace this with actual logic
        boolean isValidUser = validateUser(loginRequest.getUsername(), loginRequest.getPassword());

        return ResponseEntity.ok(isValidUser);
    }

    // Simple user validation logic (replace with actual logic)
    private boolean validateUser(String username, String password) {
        // Replace this with your actual user validation logic (e.g., check against a database)
        User user = userRepository.findByUsername(username);

        // Check if the user exists and the password matches (in a real-world scenario, use proper password hashing)
        return user != null && user.getPassword().equals(password);    }
}