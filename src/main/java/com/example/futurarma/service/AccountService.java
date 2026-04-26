package com.example.futurarma.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.futurarma.repository.TransactionRepository;
import com.example.futurarma.entity.TransactionEntity;
import com.example.futurarma.enums.TransactionType;
import java.time.LocalDateTime;
import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import com.example.futurarma.repository.AccountRepository;
import com.example.futurarma.entity.AccountEntity;
@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {
    private final AccountRepository repository;
    private final TransactionRepository transactionRepository;

    public AccountEntity create(AccountEntity account) {
        return repository.save(account);
    }

    public List<AccountEntity> getAll() {
        return repository.findAll();
    }

    public AccountEntity find(Long accountId) {
        return repository.findById(accountId)
                .orElseThrow(() ->
                        new RuntimeException("Account not found"));
    }

    public void delete(Long accountId) {
        repository.deleteById(accountId);
    }

    public void withdrawMoney(
            Long accountId,
            Integer amount) {
        if (amount <= 0) {
            throw new RuntimeException("Invalid amount");
        }
        AccountEntity account =
                repository.findById(accountId)
                        .orElseThrow(() ->
                                new RuntimeException("Account not found"));
        BigDecimal withdrawalAmount =
                BigDecimal.valueOf(amount);
        if (account.getCash()
                .compareTo(withdrawalAmount) < 0) {
            throw new RuntimeException("Insufficient cash");
        }
        account.setCash(
                account.getCash()
                        .subtract(withdrawalAmount)
        );
        repository.save(account);
        logTransaction(
                account,
                withdrawalAmount,
                TransactionType.WITHDRAW);

    }

    public void depositMoney(
            Long accountId,
            Integer amount) {
        AccountEntity account =
                repository.findById(accountId)
                        .orElseThrow(() ->
                                new RuntimeException("Account not found"));
        if (amount <= 0) {
            throw new RuntimeException("Invalid amount");
        }
        BigDecimal depositAmount =
                BigDecimal.valueOf(amount);
        account.setCash(
                account.getCash()
                        .add(depositAmount)
        );
        repository.save(account);
        logTransaction(
                account,
                depositAmount,
                TransactionType.DEPOSIT);
    }

    public void transferMoney(
            Long fromAccountId,
            Long toAccountId,
            Integer amount) {
        if (amount <= 0) {
            throw new RuntimeException("Invalid amount");
        }
        AccountEntity from =
                repository.findById(fromAccountId)
                        .orElseThrow(() ->
                                new RuntimeException("From account not found"));
        AccountEntity to =
                repository.findById(toAccountId)
                        .orElseThrow(() ->
                                new RuntimeException("To account not found"));
        BigDecimal transferAmount =
                BigDecimal.valueOf(amount);
        if (from.getCash()
                .compareTo(transferAmount) < 0) {
            throw new RuntimeException("Insufficient cash");
        }
        from.setCash(
                from.getCash()
                        .subtract(transferAmount)
        );
        to.setCash(
                to.getCash()
                        .add(transferAmount)
        );
        repository.save(from);
        repository.save(to);
        logTransaction(
                from,
                transferAmount,
                TransactionType.TRANSFER);
    }

    private void logTransaction(
            AccountEntity account,
            BigDecimal amount,
            TransactionType type) {

        TransactionEntity transaction =
                new TransactionEntity();

        transaction.setAccount(account);
        transaction.setAmount(amount);

        // CHANGE THIS LINE
        transaction.setType(type);

        transaction.setTimestamp(LocalDateTime.now());

        transactionRepository.save(transaction);
    }
}