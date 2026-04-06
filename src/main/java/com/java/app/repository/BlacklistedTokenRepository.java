package com.java.app.repository;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.app.entity.BlacklistedToken;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistedTokenRepository extends JpaRepository<BlacklistedToken, Long> {
    boolean existsByToken(String token);
    void deleteByExpiryDateBefore(Date date);
}
