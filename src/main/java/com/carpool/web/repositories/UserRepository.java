package com.carpool.web.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.carpool.web.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

