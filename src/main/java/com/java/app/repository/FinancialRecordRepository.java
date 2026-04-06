package com.java.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.app.entity.FinancialRecord;
import com.java.app.entity.RecordType;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

        @Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE f.type = :type")
        Double sumByType(RecordType type);
}
