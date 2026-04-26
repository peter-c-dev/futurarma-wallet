package com.example.futurarma.mapper;
import com.example.futurarma.dto.*;
import com.example.futurarma.entity.BankEntity;
public class BankMapper {
    private BankMapper() {}
    public static BankEntity toEntity(
            BankRequestDTO dto) {
        return BankEntity.builder()
                .bankLocation(dto.getBankLocation())
                .bankName(dto.getBankName())
                .bankOpeningHours(dto.getBankOpeningHours())
                .bankOpen(dto.isBankOpen())
                .bankRating(dto.getBankRating())
                .savingRating(dto.getSavingRating())
                .build();
    }
}