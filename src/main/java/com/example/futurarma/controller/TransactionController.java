package com.example.futurarma.controller;

import com.example.futurarma.entity.TransactionEntity;
import com.example.futurarma.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public List<TransactionEntity> getAllTransaction() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public TransactionEntity getTransaction(
            @PathVariable Long id) {
        return transactionService.getTransaction(id);
    }

    @PostMapping
    public TransactionEntity createTransaction(
            @RequestBody TransactionEntity transaction) {

        return transactionService.createTransaction(
                transaction
        );
    }
}