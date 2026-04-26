
package com.example.futurarma.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 300)
    private String bankLocation;

    @NotBlank
    @Column(nullable = false, length = 300)
    private String bankName;

    @NotBlank
    @Column(nullable = false, length = 300)
    private String bankOpeningHours;

    private boolean bankOpen;
    private Double bankRating;
    private Double savingRating;


    @OneToMany(
            mappedBy = "bank",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<AccountEntity> accounts = new ArrayList<>();

}
