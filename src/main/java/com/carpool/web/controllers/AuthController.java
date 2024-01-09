package com.carpool.web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carpool.web.models.RegistrationRequest;
import com.carpool.web.models.dto.SignupRequest;
import com.carpool.web.models.entities.UserProfile;
import com.carpool.web.services.SignupService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
  
    @Autowired
    private SignupService signupService;

    
    @PostMapping("/signup")
        public ResponseEntity<Map<String, Object>> signup(SignupRequest signupRequest) {
        // Validate and process the signup request

        // Example:
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstname(signupRequest.getFirstname());
        userProfile.setLastname(signupRequest.getLastname());
        userProfile.setMiddlename(signupRequest.getMiddlename());

        try {
            signupService.signup(userProfile, signupRequest.getEmail(), signupRequest.getPassword());
            Map<String, Object> response = new HashMap<>();
            response.put("data", true);
            response.put("message", "Signup successful");
            response.put("status", true);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("data", null);
            response.put("message", e.getMessage());
            response.put("status", false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> authenticateUser(RegistrationRequest loginRequest) {
        // Simulate user validation; replace this with actual logic
        //boolean isValidUser = validateUser(loginRequest.getUsername(), loginRequest.getPassword());

        return ResponseEntity.ok(true);
    }
}