package com.example.futurarma.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.futurarma.entity.TransactionEntity;
public interface TransactionRepository
        extends JpaRepository<TransactionEntity, Long> {
}