package com.example.futurarma.dto;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRequestDTO {
    @NotBlank
    private String accountName;
    @NotNull
    private Integer bankPin;
    @NotNull
    private BigDecimal cash;
    private boolean accountOpen;
    private boolean transactionsAllowed;

}