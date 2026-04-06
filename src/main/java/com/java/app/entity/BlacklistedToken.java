package com.java.app.entity;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BlacklistedToken {

    @Id @GeneratedValue
    private Long id;

    @Column(length = 500)
    private String token;

    private Date expiryDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
    
}
