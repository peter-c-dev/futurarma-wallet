package com.example.futurarma.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import com.example.futurarma.enums.AccountStatus;
import com.example.futurarma.entity.BankEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankEntity bank;
    @ManyToOne
    @JoinColumn(name = "character_id")
    private CharacterEntity character;
    @NotBlank
    @Column(nullable = false, length = 300)
    private String accountName;
    @NotNull
    private Integer bankPin;
    @NotNull
    private BigDecimal cash;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private boolean accountOpen;
    private boolean transactionsAllowed;
    @OneToMany(
            mappedBy = "account",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<TransactionEntity> transactions = new ArrayList<>();
}
