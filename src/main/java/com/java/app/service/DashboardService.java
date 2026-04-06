package com.java.app.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.java.app.entity.RecordType;
import lombok.RequiredArgsConstructor;
import com.java.app.repository.FinancialRecordRepository;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final FinancialRecordRepository repo;

    public Map<String, Double> summary() {

        Double income = repo.sumByType(RecordType.INCOME);
        Double expense = repo.sumByType(RecordType.EXPENSE);

        income = income == null ? 0 : income;
        expense = expense == null ? 0 : expense;

        return Map.of(
                "totalIncome", income,
                "totalExpense", expense,
                "netBalance", income - expense
        );
    }
}
