package com.carpool.web.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.carpool.web.models.CarpoolUser;

public interface UserRepository extends JpaRepository<CarpoolUser, Long> {
    CarpoolUser findByUsername(String username);
}

