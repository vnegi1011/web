package com.carpool.web.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carpool.web.models.entities.LoginData;

public interface LoginDataRepository extends JpaRepository<LoginData, Long> {
    Optional<LoginData> findByEmail(String email);
}

