package com.carpool.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carpool.web.models.entities.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    // Add custom queries if needed
}

