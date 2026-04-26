package com.example.futurarma.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.futurarma.service.BankService;
import com.example.futurarma.entity.BankEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/banks")
@RequiredArgsConstructor
public class BankController {
    private final BankService service;
    @PostMapping
    public BankEntity create(@Valid @RequestBody BankEntity bank) {
        return service.create(bank);
    }
    @GetMapping
    public List<BankEntity> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public BankEntity getById(@PathVariable Long id) {
        return service.find(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
