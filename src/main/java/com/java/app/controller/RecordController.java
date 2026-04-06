package com.java.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.app.entity.FinancialRecord;
import lombok.RequiredArgsConstructor;
import com.java.app.service.RecordService;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService service;

    @PostMapping
    public FinancialRecord create(@RequestBody FinancialRecord r) {
        return service.create(r);
    }

    @GetMapping
    public List<FinancialRecord> getAll() {
        return service.getAll();
    }
}
