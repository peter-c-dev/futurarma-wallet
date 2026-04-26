package com.example.futurarma.dto;
import jakarta.validation.constraints.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankRequestDTO {
    @NotBlank
    private String bankLocation;
    @NotBlank
    private String bankName;
    @NotBlank
    private String bankOpeningHours;

    private boolean bankOpen;
    private Double bankRating;
    private Double savingRating;
}
