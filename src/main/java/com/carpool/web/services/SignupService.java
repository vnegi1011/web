package com.carpool.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carpool.web.models.entities.LoginData;
import com.carpool.web.models.entities.UserProfile;
import com.carpool.web.repositories.LoginDataRepository;
import com.carpool.web.repositories.UserProfileRepository;

@Service
public class SignupService {
    @Autowired
    private LoginDataRepository loginDataRepository;
    
    @Autowired
    private UserProfileRepository userProfileRepository;
    
    public void signup(UserProfile userProfile, String email, String password) {
        // Check if the email is already registered
        if (loginDataRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email is already registered");
        }

        // Create LoginData
        LoginData loginData = new LoginData();
        loginData.setEmail(email);
        loginData.setPassword(password);

        // Save LoginData
        loginDataRepository.save(loginData);

        // Link UserProfile with LoginData using the generated userID
        userProfile.setUserID(loginData.getUserID());

        // Save UserProfile
        userProfileRepository.save(userProfile);
    }
}

