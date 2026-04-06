package com.java.app.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.java.app.entity.BlacklistedToken;
import lombok.RequiredArgsConstructor;
import com.java.app.repository.BlacklistedTokenRepository;

@Service
@RequiredArgsConstructor
public class TokenBlacklistService {

    private final BlacklistedTokenRepository repo;

    public void blacklist(String token, Date expiry) {
        BlacklistedToken t = new BlacklistedToken();
        t.setToken(token);
        t.setExpiryDate(expiry);
        repo.save(t);
    }

    public boolean isBlacklisted(String token) {
        return repo.existsByToken(token);
    }

    @Scheduled(cron = "0 0 * * * ?")
    public void clean() {
        repo.deleteByExpiryDateBefore(new Date());
    }
}
