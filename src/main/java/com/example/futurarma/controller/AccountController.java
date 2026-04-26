package com.example.futurarma.controller;

import com.example.futurarma.entity.AccountEntity;
import com.example.futurarma.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;


    @PostMapping
    public AccountEntity create(
            @RequestBody AccountEntity account
    ) {
        return service.create(account);
    }


    @GetMapping
    public List<AccountEntity> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public AccountEntity getOne(@PathVariable Long id) {
        return service.find(id);
    }
    @PostMapping("/withdraw")
    public void withdraw(
            @RequestParam Long accountId,
            @RequestParam Integer amount) {
        service.withdrawMoney(accountId, amount);
    }


    @PostMapping("/deposit")
    public void deposit(
            @RequestParam Long accountId,
            @RequestParam Integer amount) {
        service.depositMoney(accountId, amount);
    }

    @PostMapping("/transfer")
    public void transfer(
            @RequestParam Long fromAccountId,
            @RequestParam Long toAccountId,
            @RequestParam Integer amount) {
        service.transferMoney(
                fromAccountId,
                toAccountId,
                amount);
    }
}