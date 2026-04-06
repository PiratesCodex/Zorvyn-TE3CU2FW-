package com.java.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.app.entity.FinancialRecord;
import lombok.RequiredArgsConstructor;
import com.java.app.repository.FinancialRecordRepository;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final FinancialRecordRepository repo;

    public FinancialRecord create(FinancialRecord r) {
        return repo.save(r);
    }

    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }
}
