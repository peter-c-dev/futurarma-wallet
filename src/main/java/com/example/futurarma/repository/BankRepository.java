package com.example.futurarma.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.futurarma.entity.BankEntity;
public interface BankRepository
        extends JpaRepository<BankEntity, Long> {
}