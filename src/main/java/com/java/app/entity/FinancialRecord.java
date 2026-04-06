package com.java.app.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FinancialRecord {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private RecordType type;

    private String category;

    private LocalDate date;

    private String notes;

    @ManyToOne
    private User createdBy;
}