package com.example.futurarma.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.futurarma.entity.AccountEntity;
public interface AccountRepository
        extends JpaRepository<AccountEntity, Long> {
}