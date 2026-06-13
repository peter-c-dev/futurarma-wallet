package com.example.futurarma.service;

import com.example.futurarma.entity.TransactionEntity;
import com.example.futurarma.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

private final TransactionRepository transactionRepository;

public List<TransactionEntity> getAllTransactions() {
    return transactionRepository.findAll();
}

public TransactionEntity createTransaction(
        TransactionEntity transaction) {

    return transactionRepository.save(transaction);

}
public TransactionEntity getTransaction(
        Long id) {
    return transactionRepository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException(
                            "Transaction not found"));

}
}
