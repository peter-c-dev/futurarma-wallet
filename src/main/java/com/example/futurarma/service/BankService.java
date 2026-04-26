
package com.example.futurarma.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.example.futurarma.repository.BankRepository;
import com.example.futurarma.entity.BankEntity;
@Service
@RequiredArgsConstructor
@Transactional
public class BankService {
    private final BankRepository repository;
    public BankEntity create(BankEntity bank) {
        return repository.save(bank);
    }
    public List<BankEntity> getAll() {
        return repository.findAll();
    }
    public BankEntity find(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Bank not found"));
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}